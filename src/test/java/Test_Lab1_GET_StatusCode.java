import io.restassured.response.Response;
import static io.restassured.RestAssured.get;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Lab1_GET_StatusCode {

        @Test
        public void testGetRequest_ResponseStatusCodeOk() {
            Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1");
            Assert.assertEquals(response.statusCode(), 200);
        }

        @Test
        public void testGetRequest_ResponseStatusCode404() {
            Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/-1");
            Assert.assertEquals(response.statusCode(), 404);
        }

    }
