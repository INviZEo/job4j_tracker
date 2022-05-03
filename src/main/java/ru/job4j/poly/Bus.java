package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public String ride() {
        return null;
    }

    @Override
    public int passengers(int quantityHuman) {
        return 0;
    }

    @Override
    public int refuel(int fuel) {
        return 0;
    }
}
