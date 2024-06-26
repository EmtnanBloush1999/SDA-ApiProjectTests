package Assignments;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.UserInfoClass;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Homework9 {

    /**
     * Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
     */

    @Test
    public void test() {
        //Set the url
        String url = "https://petstore.swagger.io/v2/user";

        //set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("code", 200);
        expectedData.put("type", "unknown");
        expectedData.put("message", "999");


        //set the request and got the response
        UserInfoClass Data = new UserInfoClass(999, "Asahi", "Emtnan", "Bloush"
                , "Emtnan@gmail.com", "12345", "059999999");
        System.out.println("Data = " + Data);

        Response response = given()
                .body(Data)
                .contentType(ContentType.JSON)
                .post(url);
        response.prettyPrint();

        //do assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo((int) expectedData.get("code"))
                        , "type", equalTo((String) expectedData.get("type"))
                        , "message", equalTo((String) expectedData.get("message"))
                );
    }
}
