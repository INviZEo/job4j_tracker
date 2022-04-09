package ru.job4j.inheritance;

public class Builder extends Engineer {
    private int build;

    public Builder(String name, String surname, String education, String birthday, String did, int build) {
        super(name, surname, education, birthday, did);
        this.build = build;
    }

    public int getBuild() {
        return build;
    }
}
