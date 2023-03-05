import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab5_Test_POST_Response {
    @Test
    public void testPostRequest_response(){
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.body("{\"Name\":\"qa-test-999\",\"IsComplete\":false}");

        String expectedName = "qa-test-999";

        Response response = request.post("https://peselvalidatorapitest.azurewebsites.net/api/Todo");
        int actualId = response.path("id");

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertFalse(response.path("isComplete"));
        Assert.assertEquals(response.path("name"),expectedName);
        // id>0
        Assert.assertTrue(actualId>0);

    }
}
