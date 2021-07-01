package pl.mradomyski.restassured.requests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetBookingIds {

    public static Response getBookingIds() throws URISyntaxException, IOException {

        return
                given().filter(new AllureRestAssured())
                        .when()
                        .get("/booking")
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(200)
                        .assertThat().body(matchesJsonSchemaInClasspath("schemas/booking-ids-schema.json"))
                        .extract()
                        .response();
    }

    public static HashMap<String, Integer> parseBookingIds(Response response) {

        HashMap<String, Integer> bookingIdsMap = new HashMap<>();
        return bookingIdsMap;
    }
}
