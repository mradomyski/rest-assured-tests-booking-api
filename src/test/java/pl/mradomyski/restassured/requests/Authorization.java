package pl.mradomyski.restassured.requests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pl.mradomyski.restassured.utils.JSONUtils;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Authorization {

    public static Response getToken() throws URISyntaxException, IOException {
        JSONUtils jsonUtils = new JSONUtils();
        String jsonBody = jsonUtils.generateStringifiedJSONFromResource(
                "/testdata/user-login.json");

        return
                given().filter(new AllureRestAssured())
                        .contentType(ContentType.JSON)
                        .body(jsonBody)
                        .when()
                        .post("/auth")
                        .then().log().ifValidationFails(LogDetail.BODY).statusCode(200)
                        .assertThat().body(matchesJsonSchemaInClasspath("schemas/auth-schema.json"))
                        .extract()
                        .response();
    }

    public static String parseForAccessToken(Response loginResponse) {
        return loginResponse.jsonPath().getString("token");
    }
}
