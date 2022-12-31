package testCases;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RegisterPage {

     String requestBody = "{\n" +
            "\"password\": \"123456\",\n" +
            "\"password_confirmation\": \"123456\",\n" +
            "\"favorite_language\": \"en\",\n" +
            "\"responsible_person\": \"Test_Automation\",\n" +
            "\"is_accept_terms_and_conditions\": true,\n" +
            "\"name\": \"Test_Automation Name\",\n" +
            "\"mobile\": 966556577000,\n" +
            "\"email\": \"Test_Automation@gmail.com\"\n" +
            "} ";
@Test
public void register() {

                Response response=RestAssured.given()
                        .baseUri(CommonAPI.baseUrl)
                        .header("Content-Type", "application/json").header("Platform", "careferProviderApplication2Ej!%")
                        .body(requestBody)
                        .log().all()
                        .when()
                        .post("/v1/auth/register")
                        .then()
                        .log().all()
                        .extract().response();
    Assert.assertEquals(response.getStatusCode(),200);

    }
}
