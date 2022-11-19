package pl.mradomyski.restassured.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void setup() {

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "https://restful-booker.herokuapp.com";
        }
        RestAssured.baseURI = baseHost;

    }
}
