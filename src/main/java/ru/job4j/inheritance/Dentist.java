package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String anesthetic;

    public Dentist(String name, String surname, String education, String birthday, String quality, String anesthetic) {
        super(name, surname, education, birthday, quality);
        this.anesthetic = anesthetic;
    }

    public String getAnesthetic() {
        return anesthetic;
    }
}
