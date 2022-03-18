package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String massage;

    public static void main(String[] args) {
        Error error = new Error(false, 1, "fault");
        error.check();
    }


    public Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void check() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(massage);
    }
}
