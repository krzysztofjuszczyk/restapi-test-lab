import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.post;

import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab4_Test_POST_StatusCode {

    @Test
    public void testPostRequest_responseStatusCode(){



        RequestSpecification req = RestAssured.given();
        //v.1
        //        req.header("Content-Type", "application/json");

        req.contentType(ContentType.JSON);
         req.body("{\"Name\":\"qa-test-001\",\"IsComplete\":false}");


        Response response = req.post("https://peselvalidatorapitest.azurewebsites.net/api/Todo");

        Assert.assertEquals(response.statusCode(), 201);

    }
}
