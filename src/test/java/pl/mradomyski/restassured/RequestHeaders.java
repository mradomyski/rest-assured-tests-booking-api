package pl.mradomyski.restassured;

import java.util.HashMap;

public class RequestHeaders {

    public static HashMap<String, String> setBaseRequestHeaders() {
        HashMap<String, String> baseRequestHeaders = new HashMap<String, String>();

        baseRequestHeaders.put("App-Version", "3.59");
        baseRequestHeaders.put("Device-Os", "1");
        baseRequestHeaders.put("Device-Os-Version", "iOS 13.3");
        baseRequestHeaders.put("Device-Region-Format", "en-US");
        baseRequestHeaders.put("Device-Time-Zone", "Europe/Paris}");
        baseRequestHeaders.put("Content-Type", "application/json");
        baseRequestHeaders.put("Accept-Language", "en-us");
        baseRequestHeaders.put("Accept-Encoding", "gzip, deflate, br");
        baseRequestHeaders.put("Connection", "keep-alive");
        baseRequestHeaders.put("Accept", "*/*");
        return baseRequestHeaders;
    }
}
