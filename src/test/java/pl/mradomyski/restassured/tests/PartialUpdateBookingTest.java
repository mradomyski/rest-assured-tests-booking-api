package pl.mradomyski.restassured.tests;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.mradomyski.restassured.pojos.Booking;
import pl.mradomyski.restassured.utils.BookingRandomizer;

import java.io.IOException;
import java.net.URISyntaxException;

import static pl.mradomyski.restassured.requests.PartialUpdateBooking.partiallyUpdateBooking;
import static pl.mradomyski.restassured.utils.CommonActions.*;

public class PartialUpdateBookingTest extends TestBase {

    private final Logger logger = LogManager.getLogger(PartialUpdateBookingTest.class);
    private final Gson gson = new Gson();

    @Test
    @Step("Partially update specific booking with random data")
    public void partiallyUpdateBookingPlease() throws URISyntaxException, IOException {
        String requestBodyForAccessToken = getJsonBodyString("/testdata/user-login.json");
        String accessToken = getAccessToken(requestBodyForAccessToken);

        BookingRandomizer randomizer = new BookingRandomizer();
        Booking alteredBooking = randomizer.giveMeRandomCredentials();
        String requestBody = gson.toJson(alteredBooking);

        Response response = partiallyUpdateBooking(getRandomExistingBookingId(), requestBody, accessToken);
        Booking responseBooking = parseBooking(response);

        Assert.assertEquals(responseBooking.getFirstName(), alteredBooking.getFirstName());
        Assert.assertEquals(responseBooking.getLastName(), alteredBooking.getLastName());
  
        logger.info("Partially updating booking with random data");

    }
}