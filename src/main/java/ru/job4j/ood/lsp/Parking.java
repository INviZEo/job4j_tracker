package ru.job4j.ood.lsp;

import java.util.List;
import java.util.function.Predicate;

public interface Parking {
    List<Car> parkCars(int sizePark, Car car);

    void add(Car car);
}
