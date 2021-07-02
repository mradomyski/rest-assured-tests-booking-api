package pl.mradomyski.restassured.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import javafx.util.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.mradomyski.restassured.pojos.Booking;

import java.io.IOException;
import java.net.URISyntaxException;

import static pl.mradomyski.restassured.requests.UpdateBooking.updateBooking;
import static pl.mradomyski.restassured.utils.CommonActions.*;

public class UpdateBookingTest extends TestBase {


    private final Logger logger = LogManager.getLogger(UpdateBookingTest.class);

    @Test
    @Step("Update specific booking with random data")
    public void updateBookingPlease() throws URISyntaxException, IOException {
        Pair<String, Booking> bookingPair = getRandomBookingPair();

        Response response = updateBooking(bookingPair.getKey(), getRandomExistingBookingId());
        Booking responseBooking = parseBooking(response);

        ObjectMapper mapper = new ObjectMapper();
        Assert.assertEquals(mapper.readTree(responseBooking.toString()), mapper.readTree(bookingPair.getValue().toString()));

        logger.info("Updating booking with random data");
    }
}