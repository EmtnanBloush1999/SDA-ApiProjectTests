package Assignments.Homework15;

import base_urls.UserContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class H15_DeleteUser extends UserContactListBaseUrl {


    @Test
    public void DeleteUserTest(){

        //Set the Url
        spec.pathParams("first", "users","second", "me");

        //Set the expected data


        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200);
    }
}
