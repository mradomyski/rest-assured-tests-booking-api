package pl.mradomyski.restassured.requests;

import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static pl.mradomyski.restassured.utils.CommonActions.getAccessToken;
import static pl.mradomyski.restassured.utils.CommonActions.getRandomExistingBookingId;

public class DeleteBooking {

    public static Response deleteBooking() throws IOException, URISyntaxException {

        String accessToken = getAccessToken();
        return
                given()
                        .header("Cookie", "token=" + accessToken)
                        .when()
                        .delete("/booking/" + getRandomExistingBookingId())
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(201)
                        .extract()
                        .response();
    }

    public static String parseForAccessToken(Response loginResponse) {
        return loginResponse.jsonPath().getString("token");
    }
}