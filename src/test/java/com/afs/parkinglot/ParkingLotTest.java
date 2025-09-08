package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_a_ticket_given_a_parking_lot_and_a_car_when_parking_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        // when
        Ticket ticket = parkingLot.park(car);
        // then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_null_given_a_full_parking_lot_and_a_car_when_parking_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        // when
        ParkingException exception = assertThrows(ParkingException.class, () -> {
            parkingLot.park(car);
        });
        // then
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void should_return_a_parked_car_given_a_parking_lot_and_a_valid_ticket_when_fetch_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.park(new Car());
        // when
        Car car = parkingLot.fetch(ticket);
        // then
        assertNotNull(car);
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
        ParkingException exception = assertThrows(ParkingException.class, () -> {
            parkingLot.fetch(ticket);
        });
        // then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_null_given_a_parking_lot_and_an_used_ticket_when_fetch_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.park(new Car());
        // when
        parkingLot.fetch(ticket);
        ParkingException exception = assertThrows(ParkingException.class, () -> {
            parkingLot.fetch(ticket);
        });
        // then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_a_ticket_given_a_parking_lot_and_a_car_and_a_standard_boy_when_parking_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        StandardBoy standardBoy = new StandardBoy(parkingLot);
        // when
        Ticket ticket = standardBoy.park(car);
        // then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_null_given_a_full_parking_lot_and_a_car_and_a_standard_boy_when_parking_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        StandardBoy standardBoy = new StandardBoy(parkingLot);
        // when
        ParkingException exception = assertThrows(ParkingException.class, () -> {
            standardBoy.park(car);
        });
        // then
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void should_return_a_parked_car_given_a_parking_lot_and_a_valid_ticket_and_a_standard_boy_when_fetch_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.park(new Car());
        StandardBoy standardBoy = new StandardBoy(parkingLot);
        // when
        Car car = standardBoy.fetch(ticket);
        // then
        assertNotNull(car);
    }

    @Test
    public void should_return_correct_car_for_each_ticket_given_two_cars_and_two_tickets_and_standard_boy() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Car parkingCar1 = new Car();
        Car parkingCar2 = new Car();
        Ticket ticket1 = parkingLot.park(parkingCar1);
        Ticket ticket2 = parkingLot.park(parkingCar2);
        StandardBoy standardBoy = new StandardBoy(parkingLot);
        // when
        Car fetchCar1 = standardBoy.fetch(ticket1);
        Car fetchCar2 = standardBoy.fetch(ticket2);
        // then
        assertEquals(parkingCar1, fetchCar1);
        assertEquals(parkingCar2, fetchCar2);
    }

    @Test
    public void should_return_null_given_a_parking_lot_and_a_wrong_ticket_and_a_standard_boy_when_fetch_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = new Ticket();
        StandardBoy standardBoy = new StandardBoy(parkingLot);
        // when
        ParkingException exception = assertThrows(ParkingException.class, () -> {
            standardBoy.fetch(ticket);
        });
        // then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_null_given_a_parking_lot_and_an_used_ticket_and_a_standard_boy_when_fetch_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.park(new Car());
        StandardBoy standardBoy = new StandardBoy(parkingLot);
        parkingLot.fetch(ticket);
        // when
        ParkingException exception = assertThrows(ParkingException.class, () -> {
            standardBoy.fetch(ticket);
        });
        // then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
