package Assignments.Homework13;

import base_urls.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetStorePojo_User;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class H13_UpdateUser extends SwaggerBaseUrl {

    //Write an automation test that will create a 'user' then read, update and delete the created user using the
    // "https://petstore.swagger.io/" document. (Create a classes for each request.)


    public static String New_username;

    @Test
    public void updateUserTest() {
        // Set the URL
        spec.pathParams("first", "v2", "second", "user");

        // Set the new user data
        String updatedJson =
                """
                        {
                          "id": 123456,
                          "username": "newTest",
                          "firstName": "newUser",
                          "lastName": "test",
                          "email": "test@gmail.com",
                          "password": "0123456",
                          "phone": "0123456",
                          "userStatus": 0
                        }""";

        PetStorePojo_User updatedData = ObjectMapperUtils.convertJsonToJava(updatedJson, PetStorePojo_User.class);
        System.out.println("updatedData = " + updatedData);

        New_username = updatedData.getUsername();
        System.out.println("Username: " + New_username);

        // Send the request to update user details
        Response response = given(spec)
                .body(updatedData)
                .put("{first}/{second}/" + H13_CreateUser.username);

        response.prettyPrint();

        // Do assertion
        response
                .then()
                .statusCode(200);
    }

}