package com.viosng.asterix.db.adapter;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vio
 * Date: 01.04.2015
 * Time: 1:00
 */
public class AsterixDataProviderTest {
    @Test
    public void testGetData() throws Exception {
        DataProvider dataProvider = new AsterixDataProvider("192.168.43.128", 19002);

        System.out.println(dataProvider.getDataString("use dataverse AsterixTest;for $p in dataset Persons return $p"));

    }
}
