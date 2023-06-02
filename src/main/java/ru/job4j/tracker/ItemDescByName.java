package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item f1, Item f2) {
        return f2.getName().compareTo(f1.getName());
    }
}
