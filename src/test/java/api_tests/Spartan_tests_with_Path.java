package api_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import utilities.Config;

public class Spartan_tests_with_Path {

    @BeforeClass
    public static void setUp(){
        baseURI = Config.getProperty("spartansURL");
    }

    /*
    GIVEN accept type is Json
    AND path param id is 10
    WHEN user sends GET request to "/spartans/{id}"
    THEN status code is 200
    AND content-type is "application/json"
    AND response payload value match the following:
        "id": 67,
        "name": "Cucumber",
        "gender": "male"
     */
    @Test
    public void spartan_get_with_id_json_test_using_path () {
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 67)
                .when().get("/spartans/{id}");

        assertEquals(200, response.statusCode());
        //print response json body value
//        System.out.println(response.body().path("id").toString());
//        System.out.println(response.body().path("name").toString());
//        System.out.println(response.path("gender").toString());

        int id = response.body().path("id");
        String name = response.body().path("name");
        String gender = response.path("gender");

        System.out.println("id: " + id + "\nName: " + name + "\nGender: " + gender);
    }


}
