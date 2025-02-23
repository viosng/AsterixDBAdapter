package com.viosng.asterix.db.adapter;

import com.viosng.asterix.db.adapter.thrift.*;
import com.viosng.confsql.semantic.model.thrift.ThriftExpressionConverter;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: vio
 * Date: 29.03.2015
 * Time: 22:04
 */
public class AsterixAdapter {
    private final static Logger log = LoggerFactory.getLogger(AsterixAdapter.class);

    private final static int ASTERIX_ADAPTER_PORT = 9080;
    private final static int ENGINE_DATA_PORT = 9070;

    private static void testServices(DataProvider provider) throws TException {
        Thread thread = new Thread(() -> {
            AsterixServiceImpl service = new AsterixServiceImpl(provider);

            TServerTransport serverTransport = null;
            try {
                serverTransport = new TServerSocket(ASTERIX_ADAPTER_PORT);
            } catch (TTransportException e) {
                e.printStackTrace();
            }
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(new Hosting.Processor<>(service)));
            System.out.println("Starting the simple server...");
            server.serve();
        });
        thread.start();

        Thread engineThread = new Thread(() -> {
            TServerTransport serverTransport = null;
            try {
                serverTransport = new TServerSocket(ENGINE_DATA_PORT);
            } catch (TTransportException e) {
                e.printStackTrace();
            }
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(new Hosting.Processor<>(new Hosting.Iface() {
                @Override
                public long ntf() throws TException {
                    log.info("get ntf request");
                    return 0;
                }

                @Override
                public long execute(ThriftExpression query) throws TException {
                    log.info("get execute request");
                    return 0;
                }

                @Override
                public long setTask(HostTask task, ThriftExpression query) throws TException {
                    log.info("get setTask request");
                    return 0;
                }

                @Override
                public long getData(Data rdata) throws TException {
                    log.info("get getData request");
                    return 0;
                }
            })));
            System.out.println("Starting the simple server...");
            server.serve();
        });
        engineThread.start();

        TTransport transport;

        transport = new TSocket("localhost", ASTERIX_ADAPTER_PORT);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        Hosting.Client client = new Hosting.Client(protocol);
        TDeserializer deserializer = new TDeserializer(new TJSONProtocol.Factory());
        ThriftExpression deserializedThriftQuery = new ThriftExpression();
        deserializer.deserialize(deserializedThriftQuery,
                ThriftExpressionConverter.getInstance().toJSONProtocolString("select * from Persons where age < 30 and name < \"C\""),
                "UTF-8");
        HostTask task = new HostTask();
        task.addToOutputAddr(new HostInfo().setAddr("localhost").setPort(ENGINE_DATA_PORT));
        client.setTask(task, deserializedThriftQuery);
        client.ntf();
        transport.close();
    }

    private static void runAsterixAdapterServer(DataProvider provider) {
        AsterixServiceImpl service = new AsterixServiceImpl(provider);

        TServerTransport serverTransport = null;
        try {
            serverTransport = new TServerSocket(ASTERIX_ADAPTER_PORT);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(new Hosting.Processor<>(service)));
        log.info("Starting AsterixAdapter Server");
        server.serve();
    }

    public static void main(String[] args) throws TException {
        String address = args.length > 0 ? args[0] : "localhost";
        int port = args.length > 0 ? Integer.parseInt(args[1]) : 19002;
        runAsterixAdapterServer(new AsterixDataProvider(address, port));
        //testServices(new AsterixDataProvider("192.168.43.128", port));
    }
}
