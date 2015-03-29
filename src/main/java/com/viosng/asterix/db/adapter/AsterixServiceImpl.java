package com.viosng.asterix.db.adapter;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.viosng.asterix.db.adapter.thrift.*;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vio
 * Date: 29.03.2015
 * Time: 22:10
 */
public class AsterixServiceImpl implements Hosting.Iface {
    private final static Logger log = LoggerFactory.getLogger(AsterixServiceImpl.class);

    private AsterixDataProvider dataProvider;
    private volatile HostTask task;
    private volatile String currentData = null;

    public AsterixServiceImpl(AsterixDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public static Data convert(String s) {
        List<String> records = Splitter.on('}').omitEmptyStrings().splitToList(s);
        Data data = new Data();
        boolean schemaFilled = false;
        for (String record : records) {
            List<String> entries = Splitter.on(',').omitEmptyStrings().splitToList(record);
            Record recordValue = new Record();
            for (String entry : entries) {
                List<String> values = Splitter.on(CharMatcher.anyOf("\":{}")).omitEmptyStrings().trimResults().splitToList(entry);
                boolean isInt = isInt(values.get(1));
                boolean isDouble = isDouble(values.get(1));
                if (!schemaFilled) {
                    data.addToInfo(new AttrInfo().setName(values.get(0)).setType(
                            isInt
                                    ? AttrValType.LNG
                                    : isDouble
                                        ? AttrValType.DBL
                                        : AttrValType.STR));
                }
                if (isInt) {
                    recordValue.addToAttrs(new AttrVal().setIv(Long.parseLong(values.get(1))));
                } else if(isDouble) {
                    recordValue.addToAttrs(new AttrVal().setDv(Double.parseDouble(values.get(1))));
                } else {
                    recordValue.addToAttrs(new AttrVal().setSv(values.get(1)));
                }
            }
            data.addToVal(recordValue);
            schemaFilled = true;
        }
        return data;
    }

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException nfe) {
            return false;
        }
    }

    private static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException nfe) {
            return false;
        }
    }

    @Override
    public long ntf() throws TException {
        log.info("Received ntf request");
        TTransport transport;
        HostInfo hostInfo = task.getOutputAddr().get(0);
        log.info("opening client transport protocol to {}:{}", hostInfo.getAddr(), hostInfo.getPort());
        transport = new TSocket(hostInfo.getAddr(), (int)hostInfo.getPort());
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        Hosting.Client client = new Hosting.Client(protocol);
        Data data = convert(currentData);
        log.info("process query on Asterix, result JSON:{}", new TSerializer(new TSimpleJSONProtocol.Factory()).toString(data));
        log.info("calling getData on client");
        client.getData(convert(currentData));
        log.info("calling ntf on client");
        client.ntf();
        transport.close();
        return 0;
    }

    @Override
    public long execute(ThriftExpression query) throws TException {
        throw new UnsupportedOperationException("execute");
    }

    @Override
    public long setTask(HostTask task, ThriftExpression query) throws TException {
        log.info("Received setTask request");
        String asterixQuery = AsterixConverter.convert(query);
        log.info("converted to AQL query: {}", asterixQuery);
        this.task = task;
        currentData = dataProvider.getDataString();
        return 0;
    }

    @Override
    public long getData(Data rdata) throws TException {
        throw new UnsupportedOperationException("execute");
    }
}
