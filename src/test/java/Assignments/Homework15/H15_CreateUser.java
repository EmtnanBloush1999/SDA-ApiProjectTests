package Assignments.Homework15;

import base_urls.UserContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserContactListPojo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class H15_CreateUser extends UserContactListBaseUrl {

    //Write an automation test that will create a 'user' then read, update and delete the created user using the
    // "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.
    public static String Token;
    public static UserContactListPojo expectedData;



    @Test
    public void CreateUserTest(){

        //Set the Url
        spec.pathParams("first", "users");

        //Set the expected data
        String strJson = """
                {
                    "firstName": "Test",
                    "lastName": "User",
                    "email": "ojnndn@fake.com",
                    "password": "myPassword"
                }""";

        expectedData =  convertJsonToJava(strJson, UserContactListPojo.class);
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion


        response
                .then()
                .statusCode(201)
                .body(
                        "user.firstName", equalTo(expectedData.getFirstName()),
                        "user.lastName", equalTo(expectedData.getLastName()),
                        "user.email", equalTo(expectedData.getEmail())

                );

        Token = response.jsonPath().getString("token");
        System.out.println(Token);
    }
}
