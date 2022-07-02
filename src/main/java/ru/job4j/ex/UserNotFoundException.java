package ru.job4j.ex;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String massage) {
        super(massage);
    }
}
