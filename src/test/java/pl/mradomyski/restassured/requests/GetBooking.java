package pl.mradomyski.restassured.requests;

import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetBooking {

    public static Response getBooking(Integer id) {

        return
                given()
                        .when()
                        .get("/booking/" + id)
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(200)
                        .assertThat().body(matchesJsonSchemaInClasspath("schemas/booking-schema.json"))
                        .extract()
                        .response();
    }


}
