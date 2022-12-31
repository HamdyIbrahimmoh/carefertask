package testCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Verify {
      String requestBody="{\n" +
            "\"mobile\": 966556688000,\n" +
            "\"verification_code\": 9531\n" +
            "}";
      @Test
    public void verify(){
          Response response= RestAssured.given()
                .baseUri(CommonAPI.baseUrl)
                .header("Content-Type", "application/json").header("Platform", "careferProviderApplication2Ej!%")
                .body(requestBody)
                .log().all()
                .when()
                .post("/v1/auth/verify")
                  .then()
                  .log().all()
                  .extract().response();
          Assert.assertEquals(response.getStatusCode(),200);
    }
}
