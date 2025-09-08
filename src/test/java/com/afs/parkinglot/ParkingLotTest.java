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

    @Test
    public void should_return_the_right_car_with_each_ticket_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets_when_fetch_the_car_twice() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Car parkingCar1 = new Car();
        Car parkingCar2 = new Car();
        Ticket ticket1 = parkingLot.park(parkingCar1);
        Ticket ticket2 = parkingLot.park(parkingCar2);
        // when
        Car fetchCar1 = parkingLot.fetch(ticket1);
        Car fetchCar2 = parkingLot.fetch(ticket2);
        // then
        assertEquals(parkingCar1, fetchCar1);
        assertEquals(parkingCar2, fetchCar2);
    }
    @Test
    public void should_return_null_given_a_parking_lot_and_a_wrong_ticket_when_fetch_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = new Ticket();
        // when
        Car car = parkingLot.fetch(ticket);
        // then
        assertNull(car);
    }

    @Test
    public void should_return_null_given_a_parking_lot_and_an_used_ticket_when_fetch_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.park(new Car());
        // when
        parkingLot.fetch(ticket);
        Car secondFetchResult = parkingLot.fetch(ticket);
        // then
        assertNull(secondFetchResult);
    }

}
