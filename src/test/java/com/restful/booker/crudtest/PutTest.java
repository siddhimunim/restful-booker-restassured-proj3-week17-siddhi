package com.restful.booker.crudtest;

import com.restful.booker.model.UpdateBookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutTest extends TestBase {


    @Test
    public void updateCurrentBookingDetail() {

        UpdateBookingPojo.BookingDates date = new UpdateBookingPojo.BookingDates();
        date.setCheckin("2022-10-01");
        date.setCheckout("2022-12-01");

        UpdateBookingPojo updateBookingPojobookingPojo = new UpdateBookingPojo();

        updateBookingPojobookingPojo.setFirstname("sid");
        updateBookingPojobookingPojo.setLastname("Munim");
        updateBookingPojobookingPojo.setTotalprice(201);
        updateBookingPojobookingPojo.setDepositpaid(true);
        updateBookingPojobookingPojo.setBookingdates(date);
        updateBookingPojobookingPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=8eec60aba06a7d2")
                .pathParam("id",  1519)
                .body(updateBookingPojobookingPojo)
                .when().put("{id}");

        response.then().statusCode(200);
        response.prettyPrint();

    }
}
