package pl.mradomyski.restassured.tests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static pl.mradomyski.restassured.requests.Authorization.getToken;
import static pl.mradomyski.restassured.requests.Authorization.parseForAccessToken;

public class BookingTest extends TestBase {


    private final Logger logger = LogManager.getLogger(BookingTest.class);


    @Test
    @Step("Get access token")
    public void giveMeAccessToken() throws URISyntaxException, IOException {

        Response tokenResponse = getToken();
        String accessToken = parseForAccessToken(tokenResponse);
        Assert.assertNotNull(accessToken);

        System.out.println("ACCESS TOKEN: " + accessToken);

        logger.info("Getting access token");
    }
}