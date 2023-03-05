import io.restassured.response.Response;
import static io.restassured.RestAssured.get;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Lab2_GET_Response {
    @Test
    public void testGetRequest_Response(){
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1");
        String actualBody = response.getBody().asString();
        String expectedBody = "{\"id\":1,\"name\":\"Item1abc\",\"isComplete\":false}";

        Assert.assertEquals(actualBody,expectedBody);

    }

}
