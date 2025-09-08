package com.afs.parkinglot;

import java.util.List;

public class SmartBoy extends StandardBoy {
    public SmartBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots.sort((p1, p2) -> Integer.compare(p2.getCapacity(), p1.getCapacity()));
    }


    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailablePosition() > 0) {
                return parkingLot.park(car);
            }
        }
        throw new ParkingException("No available position.");
    }

}
