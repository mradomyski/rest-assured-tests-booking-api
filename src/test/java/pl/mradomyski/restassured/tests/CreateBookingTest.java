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

import static pl.mradomyski.restassured.requests.CreateBooking.createBooking;
import static pl.mradomyski.restassured.utils.CommonActions.getRandomBookingPair;
import static pl.mradomyski.restassured.utils.CommonActions.parseBooking;

public class CreateBookingTest extends TestBase {

    private final Logger logger = LogManager.getLogger(UpdateBookingTest.class);
    private final BookingRandomizer bookingRandomizer = new BookingRandomizer();

    @Test(priority = 4)
    @Step("Create a booking with random data")
    public void createBookingPlease() throws IOException {
        Pair<String, Booking> bookingPair = getRandomBookingPair(bookingRandomizer.giveMeRandomBooking());
        Response response = createBooking(bookingPair.getKey());
        Booking responseBooking = parseBooking(response);
        ObjectMapper mapper = new ObjectMapper();
        Assert.assertEquals(
                mapper.readTree(responseBooking.toString()),
                mapper.readTree(bookingPair.getValue().toString())
        );

        logger.info("Creating booking with random data");
    }
}
