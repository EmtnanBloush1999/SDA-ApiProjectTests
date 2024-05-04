package Assignments.Homework13;

import base_urls.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class H13_DeleteUser extends SwaggerBaseUrl {

    //Write an automation test that will create a 'user' then read, update and delete the created user using the
    // "https://petstore.swagger.io/" document. (Create a classes for each request.)

    @Test
    public void deleteUserTest() {
        // Set the URL
        spec.pathParams("first", "v2", "second", "user");

        // Set the new user data

        // Send the request to update user details
        Response response = given(spec)
                .delete("{first}/{second}/" + H13_UpdateUser.New_username);
        response.prettyPrint();
        // Do assertion
        response
                .then()
                .statusCode(200);
    }

}