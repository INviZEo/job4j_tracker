package ru.job4j.ood.lsp;

import ru.job4j.ood.srp.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ParkingCars implements Parking {

    private final int sizePark;
    private final List<Car> cars = new ArrayList<>();

    public ParkingCars(int sizePark) {
        this.sizePark = sizePark;
    }

    public int getSizePark() {
        return sizePark;
    }


    public List<Car> getCars() {
        return cars;
    }

    @Override
    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> parkCars(Predicate<Car> filter) {
        return cars.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
