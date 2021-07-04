package pl.mradomyski.restassured.requests;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static pl.mradomyski.restassured.utils.CommonActions.getAccessToken;
import static pl.mradomyski.restassured.utils.CommonActions.getJsonBodyString;

public class PartialUpdateBooking {

    public static Response partiallyUpdateBooking (Integer id) throws IOException, URISyntaxException {
        String jsonBody = getJsonBodyString("/testdata/partial-booking-update.json");

        String accessToken = getAccessToken();
        return
                given()
                        .header("Cookie", "token=" + accessToken)
                        .header("Accept", "application/json")
                        .contentType(ContentType.JSON)
                        .body(jsonBody)
                        .when()
                        .put("/booking/" + id)
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(200)
                        .assertThat().body(matchesJsonSchemaInClasspath("schemas/booking-schema.json"))
                        .extract()
                        .response();
    }
}
