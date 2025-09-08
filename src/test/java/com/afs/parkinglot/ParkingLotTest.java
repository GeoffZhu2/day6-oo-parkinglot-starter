package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_a_ticket_given_a_parking_lot_and_a_car_when_parking_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        assertNotNull(parkingLot.park(new Car()));
    }

    @Test
    public void should_return_null_given_a_full_parking_lot_and_a_car_when_parking_car() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertNull(parkingLot.park(new Car()));
    }

    @Test
    public void should_return_a_parked_car_given_a_parking_lot_and_a_valid_ticket_when_fetch_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.park(new Car());
        assertNotNull(parkingLot.fetch(ticket));
    }

}
