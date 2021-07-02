package pl.mradomyski.restassured.requests;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pl.mradomyski.restassured.pojos.Booking;
import pl.mradomyski.restassured.utils.BookingRandomizer;
import pl.mradomyski.restassured.utils.CommonActions;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static pl.mradomyski.restassured.utils.CommonActions.*;

public class UpdateBooking {

    public static Response updateBooking(String randomBookingJson, Integer id) throws IOException, URISyntaxException {

        String accessToken = getAccessToken();
        return
                given()
                        .header("Cookie", "token=" + accessToken)
                        .header("Accept", "application/json")
                        .contentType(ContentType.JSON)
                        .body(randomBookingJson)
                        .when()
                        .put("/booking/" + id)
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(200)
                        .assertThat().body(matchesJsonSchemaInClasspath("schemas/booking-schema.json"))
                        .extract()
                        .response();

    }

}
