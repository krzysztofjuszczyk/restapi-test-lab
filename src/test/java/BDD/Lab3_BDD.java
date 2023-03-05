package BDD;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Lab3_BDD {
    @Test
        public void testGetRequest_responseElementId() {
        when()
                .get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1")
                .then()
                .extract()
                .path("id")
                .equals(1);
    }

    @Test
            public void testGetRequest_responseElementName(){
                when()
                        .get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1")

                        .then()
                        .extract()
                        .path("name")
                        .equals("Item1abc");
        }


    //        @Test
    //        public void testGetRequest_responseElementName() {
    //            Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Todo/1");
    //            String actualName = response.path("name");
    //            String expectedName = "Item1abc";
    //            Assert.assertEquals(actualName, expectedName);
            }


