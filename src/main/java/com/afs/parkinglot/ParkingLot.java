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

    public Car fetch(Ticket ticket) {
        if(isValidTicket(ticket)) {
            ticket.setUsed();
            return ticketCarMap.get(ticket);
        }
        return null;
    }
    private boolean isValidTicket(Ticket ticket) {
        return !ticket.isUsed() && ticketCarMap.get(ticket) != null;
    }
}
