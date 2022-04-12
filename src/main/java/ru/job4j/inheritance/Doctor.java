package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String quality;

    public Doctor(String name, String surname, String education, String birthday, String quality) {
        super(name, surname, education, birthday);
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }
}
