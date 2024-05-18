package ru.job4j.ood.lsp;

public class LogicOfParking {

    public boolean opportunityOfParking(int parkSize, Car car) {
        boolean rsl = false;
        ParkingCars parkingCars = new ParkingCars(parkSize);
        if (car.getSize() <= parkingCars.getSizePark()) {
            parkSize = parkingCars.getSizePark() - car.getSize();
            parkingCars.setSizePark(parkSize);
            parkingCars.add(car);
            rsl = true;
        }
        return rsl;
    }
}
