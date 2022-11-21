package pl.mradomyski.restassured.requests;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static pl.mradomyski.restassured.utils.CommonActions.getJsonBodyString;

public class Authorization {

    public static Response getToken(String requestBody) throws URISyntaxException, IOException {

        return
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/auth")
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(200)
                        .extract()
                        .response();
    }

    public static String parseForAccessToken(Response loginResponse) {
        return loginResponse.jsonPath().getString("token");
    }
}
