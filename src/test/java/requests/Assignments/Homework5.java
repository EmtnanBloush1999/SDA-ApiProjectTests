package requests.Assignments;

import requests.base_urls.AssignmentBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Homework5 extends AssignmentBaseUrl{

 /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */


    @Test
    public void postRequestTest() {
        //Set the Url
        spec.pathParams("first", "api", "second", "users", "third", "23");

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server","cloudflare")
                .body("isEmpty()", Matchers.is(true));
    }
}