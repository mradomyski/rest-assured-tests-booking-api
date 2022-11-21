package pl.mradomyski.restassured.tests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.mradomyski.restassured.pojos.Booking;

import java.io.IOException;
import java.net.URISyntaxException;

import static pl.mradomyski.restassured.requests.PartialUpdateBooking.partiallyUpdateBooking;
import static pl.mradomyski.restassured.utils.CommonActions.getRandomExistingBookingId;
import static pl.mradomyski.restassured.utils.CommonActions.parseBooking;

public class PartialUpdateBookingTest extends TestBase {

    private final Logger logger = LogManager.getLogger(PartialUpdateBookingTest.class);

    @Test
    @Step("Partially update specific booking with random data")
    public void partiallyUpdateBookingPlease() throws URISyntaxException, IOException {

        Response response = partiallyUpdateBooking(getRandomExistingBookingId());
        Booking responseBooking = parseBooking(response);

        Assert.assertEquals(responseBooking.getFirstName(),"James");
        Assert.assertEquals(responseBooking.getLastName(),"Brown");


        logger.info("Partially updating booking with random data");

    }
}