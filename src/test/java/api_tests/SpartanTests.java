package api_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*; //

public class SpartanTests {
    String spartanAllURL = "http://100.26.130.128:8000/api/spartans/";

    @Test
    public void viewAllSpartansTest(){
        Response response = RestAssured.get(spartanAllURL);
        System.out.println("Status Code: " + response.statusCode());
        //System.out.println(response.body().asString());
        response.body().prettyPrint();

    }

    /*
    GIVEN -- accept type is Json
    WHEN user sends a get request to spartanAllURL
    THEN response status code is 200
    AND response body should be Json
    AND response should contain name - 'Test'
     */
    @Test
    public void viewAllSpartansTest2(){
        Response response = RestAssured.given().accept(ContentType.JSON).when().get(spartanAllURL);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("application/json", response.contentType());
        Assert.assertTrue(response.body().asString().contains("Test"));
    }

    @Test
    public void viewAllSpartansTest3(){
        // request part
                given().contentType("application/json")
                .when().get(spartanAllURL)
                .then()
                //response part
                .assertThat().statusCode(200)
                .and().contentType("application/json");
    }


}
