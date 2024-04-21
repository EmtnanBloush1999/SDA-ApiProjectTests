package requests.Assignments;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Homework4 {


     /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void AssertHeadersInfo(){
        Response response = RestAssured.get("https://reqres.in/api/users/3");
        response.prettyPrint();

        // Aseertions Tests
        response.then().statusCode(200);
        response.then().contentType("application/json");
        response.then().statusLine("HTTP/1.1 200 OK");

    }
}