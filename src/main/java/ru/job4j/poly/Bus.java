package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int quantityHuman) {
        System.out.println("Количество пассажиров в автобусе: " + quantityHuman);
    }

    @Override
    public int refuel(int fuel, int cost) {
        cost *= fuel;
        return cost;
    }
}