package com.restful.booker.crudtest;

import com.restful.booker.model.AuthorisationPojo;
import com.restful.booker.model.BookingPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTest {


    @Test
    public void createTokenId() {

        AuthorisationPojo authorisationPojo = new AuthorisationPojo();
        authorisationPojo.setUsername("admin");
        authorisationPojo.setPassword("password123");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(authorisationPojo)
                .post("https://restful-booker.herokuapp.com/auth");

        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }

    @Test
    public void createBooking() {
        BookingPojo.BookingDates date = new BookingPojo.BookingDates();
        date.setCheckin("2022-10-01");
        date.setCheckout("2022-12-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("sid");
        bookingPojo.setLastname("Thak");
        bookingPojo.setTotalprice(200);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(date);
        bookingPojo.setAdditionalneeds("Breakfast");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingPojo)
                .post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
        response.then().log().all().statusCode(200);

    }

}

