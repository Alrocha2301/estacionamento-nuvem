package com.alexandre.estacionamentonuvem.controllers;

import com.alexandre.estacionamentonuvem.controllers.dto.ParkingDTO;
import com.alexandre.estacionamentonuvem.services.ParkingService;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerIT {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setupTest() {
         RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/v1/parking")
                .then()
                .body("license[0]", Matchers.equalTo("BNJ-9123"))
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void whenCreateThenCheckIsCreated() {

        var dto = new ParkingDTO();
        dto.setColor("Branco");
        dto.setLicense("BBB-2023");
        dto.setModel("Punto");
        dto.setState("SP");

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(dto)
                .post("/v1/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("BBB-2023"))
                .body("color", Matchers.equalTo("Branco"));
    }
}