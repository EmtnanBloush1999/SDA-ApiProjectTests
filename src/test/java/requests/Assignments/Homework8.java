package requests.Assignments;

import requests.base_urls.AssignmentBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.AssignmentPlaceHolderData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework8 extends AssignmentBaseUrl {
      /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                   "name": "morpheus",
                   "job": "leader",
                   "id": "496",
                   "createdAt": "2022-10-04T15:18:56.372Z"
                   }
      */

    @Test
    public void postRequestTest() {

        //Set the Url
        spec.pathParams("first", "api", "second", "users");


        Map<String, Object> expectedData = AssignmentPlaceHolderData.expectedDataMap("morpheus", "leader");

        //Send the request and get the response
        Response response = given(spec)
                .body(expectedData)
                .post("{first}/{second}");

        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(201)
                .body("name", equalTo(expectedData.get("name")), //By map payload, we can get specific data from body. This is more dynamic.
                        "job", equalTo(expectedData.get("job")));

    }
}
