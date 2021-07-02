package pl.mradomyski.restassured.requests;

import io.restassured.filter.log.LogDetail;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetBookingIds {

    public static List<Integer> getBookingIds() {

        return
                given()
                        .when()
                        .get("/booking")
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(200)
                        .assertThat().body(matchesJsonSchemaInClasspath("schemas/booking-ids-schema.json"))
                        .extract().jsonPath().getList("bookingid");
    }
}
