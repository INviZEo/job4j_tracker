package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item f1, Item f2) {
        return f1.getName().compareTo(f2.getName());
    }
}
