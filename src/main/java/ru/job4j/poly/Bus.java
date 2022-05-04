package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
    }

    @Override
    public void passengers(int quantityHuman) {
    }

    @Override
    public int refuel(int fuel, int cost) {
        cost *= fuel;
        return cost;
    }
}