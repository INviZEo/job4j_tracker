package ru.job4j.inheritance;

import ru.job4j.tracker.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime s = item.getCreated();
        System.out.println(s.format(formatter));
    }
}
