package pl.mradomyski.restassured.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.mradomyski.restassured.pojos.Booking;
import pl.mradomyski.restassured.pojos.Pair;
import pl.mradomyski.restassured.utils.BookingRandomizer;

import java.io.IOException;
import java.net.URISyntaxException;

import static pl.mradomyski.restassured.requests.PartialUpdateBooking.partiallyUpdateBooking;
import static pl.mradomyski.restassured.utils.CommonActions.*;

public class PartialUpdateBookingTest extends TestBase {


    private final Logger logger = LogManager.getLogger(PartialUpdateBookingTest.class);
    private final BookingRandomizer bookingRandomizer = new BookingRandomizer();
/*
           This request gives 400, even while using curl request from the docs.
    @Test
    @Step("Partially update specific booking with random data")
    public void partiallyUpdateBookingPlease() throws URISyntaxException, IOException {





        Response response = partiallyUpdateBooking(getRandomExistingBookingId());
        Booking responseBooking = parseBooking(response);
        ObjectMapper mapper = new ObjectMapper();

        String jsonRequestBody = getJsonBodyString("/testdata/user-login.json");
        Assert.assertEquals(mapper.readTree(responseBooking.toString()), mapper.readTree(jsonRequestBody));

        logger.info("Partially updating booking with random data");




    }

*/
}