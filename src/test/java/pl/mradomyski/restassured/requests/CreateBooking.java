package pl.mradomyski.restassured.requests;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CreateBooking {

    public static Response createBooking(String randomBookingJson) {

        return
                given()
                        .contentType(ContentType.JSON)
                        .body(randomBookingJson)
                        .when()
                        .post("/booking/")
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(200)
                        .assertThat().body(matchesJsonSchemaInClasspath("schemas/created-booking-schema.json"))
                        .extract()
                        .response();
    }
}
