package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолёт движется по воздуху. ");
    }

    @Override
    public void thisIs() {
        System.out.println("Это Самолёт!");
    }
}
