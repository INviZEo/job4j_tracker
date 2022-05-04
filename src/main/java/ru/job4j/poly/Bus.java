package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        String onWhat = "Bicycle";
    }

    @Override
    public void passengers(int quantityHuman) {
        quantityHuman = 10;
    }

    @Override
    public int refuel(int fuel, int cost) {
        cost *= fuel;
        return cost;
    }
}