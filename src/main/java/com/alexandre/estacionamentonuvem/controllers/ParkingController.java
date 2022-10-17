package com.alexandre.estacionamentonuvem.controllers;

import com.alexandre.estacionamentonuvem.models.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @GetMapping
    public List<Parking> findAll() {
        Parking parking = new Parking();
        parking.setColor("Preto");
        parking.setLicense("ddd1234");
        parking.setModel("Fiesta");
        parking.setState("SP");

        return Arrays.asList(parking);

        //aplicando DTO para representar...

    }

}
