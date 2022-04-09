package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private int program;

    public Programmer(String name, String surname, String education, String birthday, String did, int program) {
        super(name, surname, education, birthday, did);
        this.program = program;
    }

    public int getProgram() {
        return program;
    }
}
