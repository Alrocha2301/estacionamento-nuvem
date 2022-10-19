package com.alexandre.estacionamentonuvem.services;

import com.alexandre.estacionamentonuvem.exceptions.ParkingNotFoundException;
import com.alexandre.estacionamentonuvem.models.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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
        return new ArrayList<>(parkingMap.values());
    }

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);

        if (parking == null) {
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking create(Parking parkingCreate) {
        parkingCreate.setId(getUUID());
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(parkingCreate.getId(), parkingCreate);

        return parkingCreate;
    }

    public void deleteById(String id) {
        Parking parking = parkingMap.get(id);

        if (parking == null) {
            throw new ParkingNotFoundException(id);
        }
        parkingMap.remove(id);
    }

    public Parking update(Parking parking, String id) {
        Parking updateParking = findById(id);
        updateParking.setColor(parking.getColor());

        return parkingMap.replace(id, updateParking);
    }
}
