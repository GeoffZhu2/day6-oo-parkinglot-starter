package com.afs.parkinglot;

import java.util.PriorityQueue;

public class StandardBoy {
    PriorityQueue<ParkingLot> parkingLots = new PriorityQueue<>();

    public StandardBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public StandardBoy(PriorityQueue<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCapacity() > 0) {
                return parkingLot.park(car);
            }
        }
        throw new ParkingException("No available position.");
    }

    public Car fetch(Ticket ticket) {
        return ticket.getParkingLot().fetch(ticket);
    }
}
