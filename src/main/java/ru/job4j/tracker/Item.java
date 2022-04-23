package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {

    private LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Override
    public String toString() {
        return "Item{"
               + "created=" + created.format(FORMATTER)
               + ", id=" + id
               + ", name='" + name + '\''
               + '}';
    }

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DateTimeFormatter getFormatter() {
        return FORMATTER;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void main(String[] args) {
        this.created = LocalDateTime.now();
    }
}
