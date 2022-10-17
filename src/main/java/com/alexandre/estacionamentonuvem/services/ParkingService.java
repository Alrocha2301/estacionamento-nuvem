package com.alexandre.estacionamentonuvem.services;

import com.alexandre.estacionamentonuvem.models.Parking;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        Parking parking = new Parking(id, "BNJ-9123", "SP", "Corsa", "Prata");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
//        return new ArrayList<>(parkingMap.values());
    }


    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
