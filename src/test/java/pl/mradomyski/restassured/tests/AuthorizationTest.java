package pl.mradomyski.restassured.tests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.mradomyski.restassured.pojos.ErrorMessage;
import pl.mradomyski.restassured.requests.Authorization;

import java.io.IOException;
import java.net.URISyntaxException;

import static pl.mradomyski.restassured.utils.CommonActions.*;

public class AuthorizationTest extends TestBase {

    private final Logger logger = LogManager.getLogger(AuthorizationTest.class);

    @Test(priority = 1)
    @Step("Get access token")
    public void giveMeAccessToken() throws URISyntaxException, IOException {
        String requestBody = getJsonBodyString("/testdata/user-login.json");
        String accessToken = getAccessToken(requestBody);
        Assert.assertNotNull(accessToken);

        logger.info("Getting access token");
    }

    @Test(priority = 1)
    @Step("Get access token with invalid user name")
    public void giveMeAccessTokenWithInvalidUserName() throws URISyntaxException, IOException {
        String requestBody = getJsonBodyString("/testdata/invalid-user-name-login.json");
        Response response = Authorization.getToken(requestBody);
        ErrorMessage errorMessage = parseErrorMessage(response);

        Assert.assertEquals(errorMessage.getReason(), "Bad credentials");

        logger.info("Not getting access token, authorization denied");
    }

    @Test(priority = 1)
    @Step("Get access token with invalid user password")
    public void giveMeAccessTokenWithInvalidPassword() throws URISyntaxException, IOException {
        String requestBody = getJsonBodyString("/testdata/invalid-user-password-login.json");
        Response response = Authorization.getToken(requestBody);
        ErrorMessage errorMessage = parseErrorMessage(response);

        Assert.assertEquals(errorMessage.getReason(), "Bad credentials");

        logger.info("Not getting access token, authorization denied");
    }
}