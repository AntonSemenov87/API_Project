package api_tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class SpartanTestsWithParameters {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://100.26.130.128:8000/api/spartans/";
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

}
