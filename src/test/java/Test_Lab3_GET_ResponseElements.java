import io.restassured.response.Response;
import static io.restassured.RestAssured.get;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Lab3_GET_ResponseElements {
    @Test
                public void testGetRequest_responseElementId() {
            Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1");
            int actualId = response.path("id");
            int expectedId = 1;
            Assert.assertEquals(actualId, expectedId);
        }

        @Test
        public void testGetRequest_responseElementName() {
            Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1");
            String actualName = response.path("name");
            String expectedName = "Item1abc";
            Assert.assertEquals(actualName, expectedName);
        }

}
