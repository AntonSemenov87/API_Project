package api_tests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class SpartanTestsWithParameters {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://100.26.130.128:8000/api";
    }

    @Test
    public void helloTest(){
        // request
        Response response = get("64");
        // response
        // verify status code 200
        System.out.println(response.getStatusLine());
        assertEquals(200, response.statusCode());
        // verify headers
        assertEquals("application/json", response.contentType());
        System.out.println(response.getHeader("Date"));
        assertTrue(response.headers().hasHeaderWithName("Date"));
        assertEquals("17", response.getHeader("Content-Length"));
        assertEquals("Hello from Sparta", response.body().asString());
    }

    @Test
    public void getSpartanByID_Positive_Path_Param_Test(){
        // request part
        Response response = given().accept(ContentType.JSON)
                            .and().pathParam("id", 67)
                            .when().get("/spartans/{id}");
        response.prettyPrint();
        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Cucumber"));
    }

    @Test
    public void getSpartanById_Negative_Path_Param_Test(){
        //request
        Response response = given().accept(ContentType.JSON)
                            .and().pathParam("id", 1)
                            .when().get("/spartans/{id}");
        // response validations
        assertEquals(404, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Spartan not found"));
    }

    @Test
    public void positiveTestWithQueryParameters_Search(){
        Response response = given().accept(ContentType.JSON)
                            .queryParams("gender", "Female", "nameConatins", "e")
                            .when().get("/spartans/search");
        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Female"));

    }

}
