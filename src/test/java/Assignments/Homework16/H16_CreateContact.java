package Assignments.Homework16;

import base_urls.ContactListBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import pojos.ContactListPojo;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class H16_CreateContact extends ContactListBaseUrl {

    //Write an automation test that will add a 'contact' then read, update and
    // delete the created contact then negative assert the deleted contact
    // using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.


    public static ContactListPojo expectedData;
    public static String Token;
    public static String id;

    @Test
    public void CreateContactTest() throws JsonProcessingException {
        // Set the Url
        spec.pathParams("first", "contacts");

        // Set the expected data
        String strJson = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }""";

        expectedData = convertJsonToJava(strJson, ContactListPojo.class);
        System.out.println("expectedData = " + expectedData);;

        // Send the request and get the response
        Response  response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();
        id = response.jsonPath().getString("_id");
        System.out.println(id);
        // Do assertion
        response
                .then()
                .assertThat()
                .statusCode(201)
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