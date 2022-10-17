package com.alexandre.estacionamentonuvem.controllers;

import com.alexandre.estacionamentonuvem.controllers.dto.ParkingDTO;
import com.alexandre.estacionamentonuvem.controllers.mapper.ParkingMapper;
import com.alexandre.estacionamentonuvem.models.Parking;
import com.alexandre.estacionamentonuvem.services.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/parking")
public class ParkingController {

    private final ParkingService parkingService;

    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingDTO> findAll() {

        List<Parking> parkingList = parkingService.findAll();

        List<ParkingDTO> parkingDTOList = parkingMapper.toParkingDTOList(parkingList);

        return parkingDTOList;
    }

}
