package ru.job4j.poly;

public class Realization {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle autoBus = new AutoBus();

        Vehicle[] all = new Vehicle[] {plane, train, autoBus};
        for (Vehicle v : all) {
            v.thisIs();
            v.move();
        }
    }
}
