package testCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login {
     String requestBody="{\n" +
             "\"mobile\": 966556677888,\n" +
             "\"password\": \"123456\"\n" +
             "}\n" +
             "\n";
     @Test
     public void login(){
          Response response=RestAssured
                  .given()
                  .baseUri(CommonAPI.baseUrl)
                  .header("Content-Type", "application/json").header("Platform", "careferProviderApplication2Ej!%")
                  .body(requestBody)
                  .log().all()
                  .when().post("/v1/auth/login")
                  .then()
                  .log().all()
                  .extract().response();

          Assert.assertEquals(response.getStatusCode(),200);

     }

}
