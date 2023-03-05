package BDD;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class Lab1_BDD {
    @Test
    public void testGetRequest_ResponseStatusCodeOk(){
        when()
                .get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1")
        .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testGetRequest_ResponseStatusCodeNotOK(){
            when()
                .get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/-1")
                    .then()
                        .assertThat()
                        .statusCode(404);
    }

}
