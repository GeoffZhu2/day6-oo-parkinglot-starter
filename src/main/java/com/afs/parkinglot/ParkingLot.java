package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private final Map<Ticket, Car> ticketCarMap = new HashMap<>();
    public ParkingLot(int capacity) {

        this.capacity = capacity;
    }
    public Ticket park(Car car) {
        if(capacity > 0) {
            capacity--;
            Ticket ticket = new Ticket();
            ticketCarMap.put(ticket, car);
            return ticket;
        }
        return null;
    }
}
