package com.afs.parkinglot;

import java.util.List;

public class SuperParkingBoy extends StandardParkingBoy {

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots.sort((p1, p2) ->
                Double.compare(
                        (double) p2.getAvailablePosition() / p2.getCapacity(),
                        (double) p1.getAvailablePosition() / p1.getCapacity()
                ));
    }

}
