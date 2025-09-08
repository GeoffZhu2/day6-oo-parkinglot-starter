package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Comparable<ParkingLot>{
    private int capacity;
    private final Map<Ticket, Car> ticketCarMap = new HashMap<>();
    public ParkingLot(int capacity) {

        this.capacity = capacity;
    }
    public Ticket park(Car car) {
        if(capacity <= 0) {
            throw new ParkingException("No available position.");
        }
        capacity--;
        Ticket ticket = new Ticket(this);
        ticketCarMap.put(ticket, car);
        return ticket;

    }

    public Car fetch(Ticket ticket) {
        if(!isValidTicket(ticket)) {
            throw new ParkingException("Unrecognized parking ticket.");
        }
        ticket.setUsed();
        return ticketCarMap.get(ticket);

    }
    private boolean isValidTicket(Ticket ticket) {
        return !ticket.isUsed() && ticketCarMap.get(ticket) != null;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int compareTo(ParkingLot o) {
        return getCapacity() - o.getCapacity();
    }
}
