package api_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.Config;

public class HR_API_Tests_With_Parameters {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = Config.getProperty("hrapi.baseuri");
    }

    /*
    Given accept type is Json
    And parameters: q = region_id=2
    When user sends a GET request to "/countries"
    Then status code is 200
    And Content/Type is application/json
    And payload should contain ""United States of America
     */
    @Test
    public void getCountries_using_query_parameter () {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("q", "{\"region_id\":2}")
                .when().get("/countries");

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("application/json", response.contentType());
        Assert.assertTrue(response.body().asString().contains("United States of America"));

    }





}
