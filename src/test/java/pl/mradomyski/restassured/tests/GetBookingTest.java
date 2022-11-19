package pl.mradomyski.restassured.tests;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static pl.mradomyski.restassured.requests.GetBooking.getBooking;
import static pl.mradomyski.restassured.utils.CommonActions.getRandomExistingBookingId;

public class GetBookingTest extends TestBase {

    private final Logger logger = LogManager.getLogger(GetBookingTest.class);

    @Test(priority = 3)
    @Step("Get specific booking based on provided id")
    public void giveMeSpecificBooking() {

        Integer randomBookingId = getRandomExistingBookingId();
        getBooking(randomBookingId);

        logger.info("Getting the specific booking");
    }

}

