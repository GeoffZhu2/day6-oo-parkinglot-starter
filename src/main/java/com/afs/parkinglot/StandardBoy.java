package com.afs.parkinglot;

import java.util.LinkedList;
import java.util.List;

public class StandardBoy {
    protected List<ParkingLot> parkingLots = new LinkedList<>();

    public StandardBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public StandardBoy(List<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailablePosition() > 0) {
                return parkingLot.park(car);
            }
        }
        throw new ParkingException("No available position.");
    }

    public Car fetch(Ticket ticket) {
        return ticket.getParkingLot().fetch(ticket);
    }
}
