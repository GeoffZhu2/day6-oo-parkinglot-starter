package com.afs.parkinglot;

public class StandardBoy {
    private final ParkingLot parkingLot;

    public StandardBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        return parkingLot.park(car);
    }
}
