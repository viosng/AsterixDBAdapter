package com.viosng.asterix.db.adapter;

/**
 * Created with IntelliJ IDEA.
 * User: vio
 * Date: 29.03.2015
 * Time: 22:17
 */
public class DummyDataProvider implements AsterixDataProvider {
    @Override
    public String getDataString() {
        return "{ \"id\": 1, \"name\": \"John\", \"age\": 29, \"department-id\": 2 }\n" +
                "{ \"id\": 2, \"name\": \"Tony\", \"age\": 31, \"department-id\": 3 }\n" +
                "{ \"id\": 3, \"name\": \"Peter\", \"age\": 38, \"department-id\": 2 }\n" +
                "{ \"id\": 4, \"name\": \"Bob\", \"age\": 14, \"department-id\": 1 }";
    }
}
