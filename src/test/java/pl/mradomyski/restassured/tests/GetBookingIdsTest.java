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
import static pl.mradomyski.restassured.requests.GetBookingIds.getBookingIds;

public class GetBookingIdsTest extends TestBase {


    private final Logger logger = LogManager.getLogger(BookingTest.class);


    @Test
    @Step("Get access token")
    public void giveMeBookingIds() throws URISyntaxException, IOException {
        Response response = getBookingIds();

        Assert.assertNotNull(response);

    }

    }

