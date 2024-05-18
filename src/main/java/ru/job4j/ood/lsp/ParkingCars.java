package ru.job4j.ood.lsp;

import ru.job4j.ood.srp.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ParkingCars implements Parking {

    private int sizePark;
    private final List<Car> cars = new ArrayList<>();

    public ParkingCars(int sizePark) {
        this.sizePark = sizePark;
    }

    public int getSizePark() {
        return sizePark;
    }

    public void setSizePark(int sizePark) {
        this.sizePark = sizePark;
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> parkCars(int sizePark, Car car) {
        LogicOfParking logicOfParking = new LogicOfParking();
        if (logicOfParking.opportunityOfParking(getSizePark(), car)) {
            cars.add(car);
            sizePark = getSizePark() - car.getSize();
            setSizePark(sizePark);
        }
        return cars;
    }
}
