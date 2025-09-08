package com.afs.parkinglot;

import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots.sort((p1, p2) -> Integer.compare(p2.getCapacity(), p1.getCapacity()));
    }
}
