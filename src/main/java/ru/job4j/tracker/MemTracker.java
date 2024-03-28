package ru.job4j.tracker;

import java.util.*;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<Item>();
    private int ids = 1;

    @Override
    public void delete(int id) {
        int index = indexOf(id);
        boolean del = index != -1;
        if (del) {
            items.remove(index);
        }
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
}

        @Override
        public List<Item> findByName(String key) {
            List<Item> rsl = new ArrayList<>();
            for (Item item : items) {
                if (item.getName().contains(key)) {
                    rsl.add(item);
                }
            }
            return rsl;
        }

        @Override
        public List<Item> findAll() {
            return List.copyOf(items);
        }

    @Override
    public void close() throws Exception {

    }
}