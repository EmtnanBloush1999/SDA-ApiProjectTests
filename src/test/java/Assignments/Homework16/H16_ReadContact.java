package Assignments.Homework16;

import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static Assignments.Homework16.H16_CreateContact.expectedData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class H16_ReadContact extends ContactListBaseUrl {


    @Test
    public void ReadContactTest(){

        //Set the Url
        spec.pathParams("first", "contacts");

        //Set the expected data


        //Send the request and get the response
        Response response = given(spec).get("{first}/"+H16_CreateContact.id);
        response.prettyPrint();

        //Do assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstName", equalTo(expectedData.getFirstName()),
                        "lastName", equalTo(expectedData.getLastName()),
                        "birthdate", equalTo(expectedData.getBirthdate())
                        , "country", equalTo(expectedData.getCountry())
                        , "phone", equalTo(expectedData.getPhone())
                        , "city", equalTo(expectedData.getCity())
                        , "postalCode", equalTo(expectedData.getPostalCode())
                        , "stateProvince", equalTo(expectedData.getStateProvince())
                        , "street1", equalTo(expectedData.getStreet1())
                        , "street2", equalTo(expectedData.getStreet2())
                        , "email", equalTo(expectedData.getEmail())
                );
    }
}