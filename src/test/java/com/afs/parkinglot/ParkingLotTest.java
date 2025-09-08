package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_a_ticket_given_a_parking_lot_and_a_car_when_parking_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        assertNotNull(parkingLot.park(new Car()));
    }
}
