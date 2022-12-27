package com.restful.booker.crudtest;

import com.restful.booker.model.PatchBookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {


    @Test
    public void updateARecordPartiallyCreated() {
        PatchBookingPojo patchBookingPojobookingPojo = new PatchBookingPojo();
        patchBookingPojobookingPojo.setAdditionalneeds("lunch");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=8eec60aba06a7d2")
                .pathParam("id", 1519)
                .body(patchBookingPojobookingPojo)
                .when().patch("{id}");

        response.then().statusCode(200);
        response.prettyPrint();

    }
}
