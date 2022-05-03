package ru.job4j.poly;

public interface Transport {
    String ride();

    int passengers(int quantityHuman);

    int refuel(int fuel);
}
