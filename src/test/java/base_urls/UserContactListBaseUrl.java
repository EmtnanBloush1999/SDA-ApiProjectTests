package base_urls;

import Assignments.Homework15.H15_CreateUser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class UserContactListBaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp(){
        String Token = H15_CreateUser.Token;
        System.out.println("token= " +Token);
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer " + Token)
                .setContentType(ContentType.JSON)
                .build();
    }
}