package ru.job4j.ood.lsp;

import java.util.List;
import java.util.function.Predicate;

public interface Parking {
    List<Car> parkCars(Predicate<Car> filter);

    void add(Car car);
}
