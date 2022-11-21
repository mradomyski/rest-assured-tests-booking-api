package pl.mradomyski.restassured.tests;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static pl.mradomyski.restassured.utils.CommonActions.getAccessToken;

public class AuthorizationTest extends TestBase {

    private final Logger logger = LogManager.getLogger(AuthorizationTest.class);

    @Test(priority = 1)
    @Step("Get access token")
    public void giveMeAccessToken() throws URISyntaxException, IOException {

        String accessToken = getAccessToken();
        Assert.assertNotNull(accessToken);
        System.out.println("ACCESS TOKEN: " + accessToken);
        logger.info("Getting access token");
    }
}