package pl.mradomyski.restassured.requests;

import com.google.gson.Gson;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pl.mradomyski.restassured.pojos.Booking;
import pl.mradomyski.restassured.utils.BookingRandomizer;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static pl.mradomyski.restassured.utils.CommonActions.getAccessToken;
import static pl.mradomyski.restassured.utils.CommonActions.getJsonBodyString;

public class PartialUpdateBooking {

    public static Response partiallyUpdateBooking (Integer id, String requestBody, String accessToken) throws IOException, URISyntaxException {

        return
                given()
                        .header("Cookie", "token=" + accessToken)
                        .header("Accept", "application/json")
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .patch("/booking/" + id)
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(200)
                        .assertThat().body(matchesJsonSchemaInClasspath("schemas/booking-schema.json"))
                        .extract()
                        .response();
    }
}
