package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String anesthetic;

    public Dentist(String name, String surname, String education, String birthday, String quality) {
        super(name, surname, education, birthday, quality);
    }

    public String getAnesthetic() {
        return anesthetic;
    }
}
