package com.viosng.asterix.db.adapter;

import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vio
 * Date: 29.03.2015
 * Time: 22:26
 */
public class AsterixServiceImplTest {

    @Test
    public void testParsing() throws Exception {
        AsterixDataProvider dataProvider = new DummyDataProvider();
        TSerializer serializer = new TSerializer(new TSimpleJSONProtocol.Factory());
        System.out.println(serializer.toString(AsterixServiceImpl.convert(dataProvider.getDataString())));
    }
}
