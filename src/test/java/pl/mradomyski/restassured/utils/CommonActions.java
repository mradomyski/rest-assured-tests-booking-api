package pl.mradomyski.restassured.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import pl.mradomyski.restassured.pojos.Booking;
import pl.mradomyski.restassured.pojos.BookingDates;
import pl.mradomyski.restassured.pojos.ErrorMessage;
import pl.mradomyski.restassured.pojos.Pair;
import pl.mradomyski.restassured.requests.Authorization;
import pl.mradomyski.restassured.requests.GetBookingIds;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

import static pl.mradomyski.restassured.requests.Authorization.parseForAccessToken;

public class CommonActions {

    public static Integer getRandomExistingBookingId() {
        List<Integer> bookingIdsList = GetBookingIds.getBookingIds();
        Random rand = new Random();

        return bookingIdsList.get(rand.nextInt(bookingIdsList.size()));
    }

    public static String getAccessToken(String requestBody) throws URISyntaxException, IOException {
        Response tokenResponse = Authorization.getToken(requestBody);

        return parseForAccessToken(tokenResponse);
    }


    public static Booking parseBooking(Response response) {
        Booking booking = new Booking();
        booking.setFirstName(response.jsonPath().getString("firstname"));
        booking.setLastName(response.jsonPath().getString("lastname"));
        booking.setTotalPrice(response.jsonPath().get("totalprice"));
        booking.setBookingDates(
                new BookingDates
                        (response.jsonPath().getString("bookingdates.checkin"),
                                response.jsonPath().getString("bookingdates.checkout"))
        );
        booking.setAdditionalNeeds(response.jsonPath().getString("additionalneeds"));

        return booking;
    }

    public static ErrorMessage parseErrorMessage(Response response) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setReason(response.jsonPath().getString("reason"));

        return errorMessage;
    }

    public static Pair<String, Booking> getRandomBookingPair(Booking randomBooking) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String randomBookingJson = mapper
                .writeValueAsString(randomBooking)
                .toLowerCase();

        return new Pair<>(randomBookingJson, randomBooking);
    }

    public static String getJsonBodyString(String path) throws URISyntaxException, IOException {
        JSONUtils jsonUtils = new JSONUtils();
        return jsonUtils.generateStringifiedJSONFromResource(path);
    }


}
