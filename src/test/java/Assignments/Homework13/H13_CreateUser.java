package Assignments.Homework13;

import base_urls.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetStorePojo_User;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class H13_CreateUser extends SwaggerBaseUrl {

    //Write an automation test that will create a 'user' then read, update and delete the created user using the
    // "https://petstore.swagger.io/" document. (Create a classes for each request.)

    public static String username;

    @Test
    public void CreateUserTest (){

        //Set the Url
        spec.pathParams("first", "v2", "second", "user");

        //Set the expected data
        String strJson =
                """
                        {
                          "id": 123456,
                          "username": "Test",
                          "firstName": "user",
                          "lastName": "test",
                          "email": "test@gmail.com",
                          "password": "0123456",
                          "phone": "0123456",
                          "userStatus": 0
                        }""";

        PetStorePojo_User expectedData = ObjectMapperUtils.convertJsonToJava(strJson, PetStorePojo_User.class);
        System.out.println("expectedData = " + expectedData);

        username = expectedData.getUsername();
        System.out.println("Username: " + username);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200)
                .body(  "code", equalTo(200),
                        "type", equalTo("unknown"),
                        "message", equalTo("123456") );
    }
}