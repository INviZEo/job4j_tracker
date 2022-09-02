package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {

    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public List<Item> add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }
}
