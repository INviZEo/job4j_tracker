package ru.job4j.poly;

public interface Transport {
    void ride();

    void passengers(int quantityHuman);

    int refuel(int fuel, int cost);
}
