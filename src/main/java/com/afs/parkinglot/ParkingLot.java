package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Comparable<ParkingLot>{
    private final int capacity;
    private int availablePosition;
    private final Map<Ticket, Car> ticketCarMap = new HashMap<>();
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availablePosition = capacity;
    }
    public Ticket park(Car car) {
        if(availablePosition <= 0) {
            throw new ParkingException("No available position.");
        }
        availablePosition--;
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

    public int getAvailablePosition() {
        return availablePosition;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int compareTo(ParkingLot o) {
        return getAvailablePosition() - o.getAvailablePosition();
    }
}
