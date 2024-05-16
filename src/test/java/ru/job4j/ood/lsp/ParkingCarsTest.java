package ru.job4j.ood.lsp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
        parkingCars.add(truck);
        parkingCars.add(truck1);
        parkingCars.add(truck2);
        parkingCars.add(truck3);
        assertThat(parkingCars.parkCars(car -> car.getSize() > parkingCars.getSizePark()).size() == 4);
    }

    @Test
    public void parkTrucksNotPassed() {
        Truck truck = new Truck("Monster", 4);
        Truck truck1 = new Truck("Belaz", 4);
        Truck truck2 = new Truck("Truck", 4);
        Truck truck3 = new Truck("Kamaz", 4);
        ParkingCars parkingCars = new ParkingCars(12);
        parkingCars.add(truck);
        parkingCars.add(truck1);
        parkingCars.add(truck2);
        parkingCars.add(truck3);
        assertThat(parkingCars.parkCars(car -> car.getSize() > parkingCars.getSizePark()).size() == 3);
    }

    @Test
    public void parkPassengerCarsPassed() {
        PassengerCar passengerCar = new PassengerCar("Lada", 1);
        PassengerCar passengerCar1 = new PassengerCar("Supra", 1);
        ParkingCars parkingCars = new ParkingCars(5);
        parkingCars.add(passengerCar);
        parkingCars.add(passengerCar1);
        assertThat(parkingCars.parkCars(car -> car.getSize() > parkingCars.getSizePark()).size() == 2);
    }
}