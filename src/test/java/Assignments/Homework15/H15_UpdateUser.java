package Assignments.Homework15;

import base_urls.UserContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserContactListPojo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.convertJsonToJava;


public class H15_UpdateUser extends UserContactListBaseUrl {


    @Test
    public void UpdateUserTest(){

        //Set the Url
        spec.pathParams("first", "users","second", "me");

        //Set the expected data

        //Set the expected data
        String strJson = """
                {
                    "firstName": "update",
                    "lastName": "User",
                    "email": "iveupdata@fake.com",
                    "password": "myPassword"
                }""";

        UserContactListPojo expectedData =  convertJsonToJava(strJson, UserContactListPojo.class);
        System.out.println("expectedData = " + expectedData);



        //Send the request and get the response
        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200)
                .body(
                        "firstName", equalTo(expectedData.getFirstName()),
                        "lastName", equalTo(expectedData.getLastName()),
                        "email", equalTo(expectedData.getEmail())

                );
    }
}