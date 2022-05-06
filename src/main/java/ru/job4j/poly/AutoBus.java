package ru.job4j.poly;

public class AutoBus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус движется по асфальту. ");
    }

    @Override
    public void thisIs() {
        System.out.println("Это Автобус!");
    }
}
