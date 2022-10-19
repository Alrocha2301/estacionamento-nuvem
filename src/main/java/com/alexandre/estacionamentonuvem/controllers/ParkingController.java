package com.alexandre.estacionamentonuvem.controllers;

import com.alexandre.estacionamentonuvem.controllers.dto.ParkingCreateDto;
import com.alexandre.estacionamentonuvem.controllers.dto.ParkingDTO;
import com.alexandre.estacionamentonuvem.controllers.mapper.ParkingMapper;
import com.alexandre.estacionamentonuvem.models.Parking;
import com.alexandre.estacionamentonuvem.services.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<List<ParkingDTO>> findAll() {

        List<Parking> parkingList = parkingService.findAll();

        List<ParkingDTO> parkingDTOList = parkingMapper.toParkingDTOList(parkingList);

        return ResponseEntity.status(HttpStatus.OK).body(parkingDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
        Parking parking = parkingService.findById(id);
        ParkingDTO parkingDTO = parkingMapper.toParkingDTO(parking);

        return ResponseEntity.status(HttpStatus.OK).body(parkingDTO);
    }

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDto dto) {
        Parking parking = parkingService.create(parkingMapper.toParkingCreate(dto));

        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id,
                                             @RequestBody ParkingCreateDto dto) {
        Parking parking = parkingService.update(parkingMapper.toParkingCreate(dto), id);

        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id) {
        parkingService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Parking excluído com sucesso");
    }

    @PostMapping("/{id}")
    public ResponseEntity<ParkingDTO> exit(@PathVariable String id) {
        Parking parking = parkingService.exit(id);

        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }



}
