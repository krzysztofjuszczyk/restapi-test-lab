package BDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Lab5_BDD {
    @Test
    public void testPostRequest_responseNotExisting_BDD(){
        String expectedName = "qa-test-999";

        Response response =
        given()
                .header("Content-Type", "application/json")
                .body("{\"Name\":\"qa-test-999\",\"IsComplete\":false}")

                .when()
                .post("https://peselvalidatorapitest.azurewebsites.net/api/Todo")

                .then()
                .statusCode(201)
                .extract()
                .response()
        ;

        int actualId = response.path("id");
        String actualName = response.path("name");
        boolean actualIsComplete = response.path("isComplete");

        Assert.assertTrue(actualId>0);
        Assert.assertEquals(actualName,expectedName);
        Assert.assertFalse(actualIsComplete);


//        RequestSpecification request = RestAssured.given();
//        request.contentType(ContentType.JSON);
//        request.body("{\"Name\":\"qa-test-999\",\"IsComplete\":false}");
//        Response response = request.post("https://peselvalidatorapitest.azurewebsites.net/api/Todo");
//        int actualId = response.path("id");

//        Assert.assertEquals(response.statusCode(), 201);
//        // id>0
//        Assert.assertTrue(actualId>0);

    }
}
