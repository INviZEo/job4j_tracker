package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String did;

    public Engineer(String name, String surname, String education, String birthday, String did) {
        super(name, surname, education, birthday);
        this.did = did;
    }

    public String getDid() {
        return did;
    }
}
