package Assignments.Homework16;

import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactListPojo;

import static Assignments.Homework16.H16_CreateContact.expectedData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class H16_UpdateContact extends ContactListBaseUrl {

    @Test
    public void UpdateContactTest() {

        //Set the Url
        spec.pathParams("first", "contacts");

        //Set the expected data
        // Set the expected data
        String strJson = """
                {
                    "firstName": "Manar",
                    "lastName": "Ahmed",
                    "birthdate": "1880-01-01",
                    "email": "manar@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "any",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }""";

        expectedData = convertJsonToJava(strJson, ContactListPojo.class);
        System.out.println("expectedData = " + expectedData);;


        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/"+H16_CreateContact.id);
        response.prettyPrint();
        // Do assertion
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