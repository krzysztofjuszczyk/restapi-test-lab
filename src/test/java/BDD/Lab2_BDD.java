package BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


public class Lab2_BDD {
    @Test
    public void testGetRequest_responseBody_bdd() {

        //  Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1");
        //        String actualBody = response.getBody().asString();
        //        String expectedBody = "{\"id\":1,\"name\":\"Item1abc\",\"isComplete\":false}";
        String expectedBody = "{\"id\":1,\"name\":\"Item1abc\",\"isComplete\":false}";

        when()
                .get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1")
                .then()
                .body(equalTo(expectedBody));
    }

    @Test
    public void testGetRequest_response_bdd() {
        String expectedBodyText = "{\"id\":1,\"name\":\"Item1abc\",\"isComplete\":false}";

        String actualBodyText = when()
                .get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1")
                .then()
                .extract()
                .asString();

        Assert.assertEquals(actualBodyText, expectedBodyText);
    }

}
