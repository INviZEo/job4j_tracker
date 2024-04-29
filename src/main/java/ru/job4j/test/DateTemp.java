package ru.job4j.test;

import java.time.format.DateTimeFormatter;

public class DateTemp {
    int temp;
    DateTimeFormatter dateTimeFormatter;

    public DateTemp(int temp, DateTimeFormatter dateTimeFormatter) {
        this.temp = temp;
        this.dateTimeFormatter = dateTimeFormatter;
    }
}
