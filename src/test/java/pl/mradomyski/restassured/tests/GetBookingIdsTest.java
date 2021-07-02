package pl.mradomyski.restassured.tests;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static pl.mradomyski.restassured.requests.GetBookingIds.getBookingIds;

public class GetBookingIdsTest extends TestBase {


    private final Logger logger = LogManager.getLogger(GetBookingIdsTest.class);


    @Test
    @Step("Get booking ids list")
    public void giveMeBookingIds() throws URISyntaxException, IOException {
        List<Integer> response = getBookingIds();
        Assert.assertNotNull(response);

        logger.info("Getting the list of booking ids");
    }

}

