package api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class HrAPITests {

    public static String URI = "";

    @Test
    public void getAllRegionsTest(){
        Response response = RestAssured.get(URI);

        System.out.println(response.statusCode());
        System.out.println(response.getContentType());
        response.body().prettyPrint();

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Europe"));

    }


}
