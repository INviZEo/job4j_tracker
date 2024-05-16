package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class ParkingCars implements Parking {

    int sizePark = 30;

    @Override
    public List<Car> parkCars(Car car) {
        List<Car> parking = new ArrayList<>();
        return parking;
    }
}
