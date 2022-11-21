package pl.mradomyski.restassured.tests;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static pl.mradomyski.restassured.requests.DeleteBooking.deleteBooking;
import static pl.mradomyski.restassured.utils.CommonActions.getAccessToken;
import static pl.mradomyski.restassured.utils.CommonActions.getJsonBodyString;

public class DeleteBookingTest extends TestBase {

    private final Logger logger = LogManager.getLogger(DeleteBookingTest.class);

    @Test(priority = 6)
    @Step("Delete specific booking")
    public void deleteThisBooking() throws URISyntaxException, IOException {
        String requestBodyForAccessToken = getJsonBodyString("/testdata/user-login.json");
        String accessToken = getAccessToken(requestBodyForAccessToken);

        deleteBooking(accessToken);

        logger.info("Deleteting specific booking");
    }
}