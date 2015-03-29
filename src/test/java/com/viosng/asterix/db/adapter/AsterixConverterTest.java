package com.viosng.asterix.db.adapter;

import com.google.common.base.Joiner;
import com.viosng.asterix.db.adapter.thrift.ThriftExpression;
import com.viosng.confsql.semantic.model.thrift.ThriftExpressionConverter;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.protocol.TJSONProtocol;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: vio
 * Date: 28.03.2015
 * Time: 20:59
 */
public class AsterixConverterTest {

    @Test
    public void testFull() throws Exception {
        String query = Joiner.on("").join(Files.readAllLines(Paths.get(
                "src/test/java/com/viosng/asterix/db/adapter/query.sql"), StandardCharsets.UTF_8));
        String json = ThriftExpressionConverter.getInstance().toJSONProtocolString(query);
        TDeserializer deserializer = new TDeserializer(new TJSONProtocol.Factory());
        ThriftExpression deserializedThriftQuery = new ThriftExpression();
        deserializer.deserialize(deserializedThriftQuery, json, "UTF-8");

        System.out.println(query);
        System.out.println(json);
        System.out.println(AsterixConverter.convert(deserializedThriftQuery));
    }
}
