package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase {


    @Test
    public void getSingleBookingID() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=8eec60aba06a7d2")
                .pathParam("id", 1519)
                .when().delete("{id}");

        response.then().statusCode(201);
        response.prettyPrint();

    }
}
