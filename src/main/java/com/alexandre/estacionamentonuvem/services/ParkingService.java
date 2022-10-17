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
        Parking parking1 = new Parking(getUUID(),"BNJ-9123", "SP", "Corsa", "Prata");
        Parking parking2 = new Parking(getUUID(),"DDX-1842", "SP", "Vectra", "Prata");
        Parking parking3 = new Parking(getUUID(), "EDY-3703", "SP", "Fiesta", "Prata");
        parkingMap.put(parking1.getId(), parking1);
        parkingMap.put(parking2.getId(), parking2);
        parkingMap.put(parking3.getId(), parking3);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
//        return new ArrayList<>(parkingMap.values());
    }

    public Parking findById(String id) {

        return parkingMap.get(id);
    }


    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
