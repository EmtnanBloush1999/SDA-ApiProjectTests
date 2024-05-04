package Assignments;

import base_urls.DummyBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Homework14 extends DummyBaseUrl {


    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */

    @Test
    public void DummyTest() {
        //set the url
        spec.pathParams("first", "v1", "second", "employees");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        // Do assertions

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body(
                        "data.size()", equalTo(24),
                        "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"),
                        "data.max { it.employee_age }.employee_age", equalTo(66),
                        "data.min { it.employee_age }.employee_name", equalTo("Tatyana Fitzpatrick"),
                        "data*.employee_salary.sum()", equalTo(6644770)
                );
    }
}