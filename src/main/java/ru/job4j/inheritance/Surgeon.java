package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String scalpel;

    public Surgeon(String name, String surname, String education, String birthday, String quality) {
        super(name, surname, education, birthday, quality);
    }

    public String getScalpel() {
        return scalpel;
    }
}
