package com.afs.parkinglot;

public class Ticket {
    private boolean isUsed = false;

    private ParkingLot parkingLot;

    public Ticket(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed() {
        this.isUsed = true;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
