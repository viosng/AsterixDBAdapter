package com.viosng.asterix.db.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: vio
 * Date: 01.04.2015
 * Time: 0:48
 */
public class AsterixDataProvider implements DataProvider {
    private final static Logger log = LoggerFactory.getLogger(AsterixDataProvider.class);

    private final String url, address;
    private final int port;

    public AsterixDataProvider(String address, int port) {
        this.address = address;
        this.port = port;
        this.url = String.format("http://%s:%d/query?query=", address, port);
    }

    @Override
    public String getDataString(String query) {
        StringBuilder response = new StringBuilder();
        URL obj;
        try {
            obj = new URL(url + URLEncoder.encode(query, "UTF-8"));

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            log.info("Sending 'GET' request to URL : " + obj);

            int responseCode = con.getResponseCode();
            log.info("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            log.error("Error occurred during GET method processing to Asterix " + address + ":" + port, e);
        }
        String result = response.toString();
        int start = result.indexOf('{'), end = result.lastIndexOf('}');
        return start >= 0 && end >= 0 ? result.substring(start, end + 1) : "";
    }
}
