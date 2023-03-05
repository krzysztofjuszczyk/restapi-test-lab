package BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

public class Lab4_BDD {
    @Test
    public void testPostRequest_responseStatusCode() {
        int expectedCode = 201;
        given()
                .header("Content-Type", "application/json")
                .body("{\"Name\":\"qa-test-001\",\"IsComplete\":false}")
                .when()
                .post("https://peselvalidatorapitest.azurewebsites.net/api/Todo")

                .then().statusCode(expectedCode);


    }
}
