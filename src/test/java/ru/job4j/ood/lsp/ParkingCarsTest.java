package ru.job4j.ood.lsp;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

@Disabled
class ParkingCarsTest {

    @Test
    public void parkTrucksPassed() {
        Truck truck = new Truck("Monster", 4);
        Truck truck1 = new Truck("Belaz", 4);
        Truck truck2 = new Truck("Truck", 4);
        Truck truck3 = new Truck("Kamaz", 4);
        ParkingCars parkingCars = new ParkingCars(20);
        parkingCars.parkCars(parkingCars.getSizePark(), truck);
        parkingCars.parkCars(parkingCars.getSizePark(), truck1);
        parkingCars.parkCars(parkingCars.getSizePark(), truck2);
        parkingCars.parkCars(parkingCars.getSizePark(), truck3);
        List<Car> expected = new ArrayList<>();
        expected.add(truck);
        expected.add(truck1);
        expected.add(truck2);
        expected.add(truck3);
        Assert.assertEquals(expected, parkingCars.getCars());
    }

    @Test
    public void parkTrucksNotPassed() {
        Truck truck = new Truck("Monster", 4);
        Truck truck1 = new Truck("Belaz", 4);
        Truck truck2 = new Truck("Truck", 4);
        Truck truck3 = new Truck("Kamaz", 4);
        ParkingCars parkingCars = new ParkingCars(12);
        parkingCars.parkCars(parkingCars.getSizePark(), truck);
        parkingCars.parkCars(parkingCars.getSizePark(), truck1);
        parkingCars.parkCars(parkingCars.getSizePark(), truck2);
        parkingCars.parkCars(parkingCars.getSizePark(), truck3);
        List<Car> expected = new ArrayList<>();
        expected.add(truck);
        expected.add(truck1);
        expected.add(truck2);
        Assert.assertEquals(expected, parkingCars.getCars());
    }

    @Test
    public void parkPassengerCarsPassed() {
        PassengerCar passengerCar = new PassengerCar("Lada", 1);
        PassengerCar passengerCar1 = new PassengerCar("Supra", 1);
        ParkingCars parkingCars = new ParkingCars(5);
        parkingCars.parkCars(parkingCars.getSizePark(), passengerCar);
        parkingCars.parkCars(parkingCars.getSizePark(), passengerCar1);
        List<Car> expected = new ArrayList<>();
        expected.add(passengerCar);
        expected.add(passengerCar1);
        Assert.assertEquals(expected, parkingCars.getCars());
    }

    @Test
    public void parkPassengerCarsNotPassed() {
        PassengerCar passengerCar = new PassengerCar("Lada", 1);
        PassengerCar passengerCar1 = new PassengerCar("Supra", 1);
        ParkingCars parkingCars = new ParkingCars(1);
        parkingCars.parkCars(parkingCars.getSizePark(), passengerCar);
        parkingCars.parkCars(parkingCars.getSizePark(), passengerCar1);
        List<Car> expected = new ArrayList<>();
        expected.add(passengerCar);
        Assert.assertEquals(expected, parkingCars.getCars());
    }
}