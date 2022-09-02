package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private final List<Item> items = new ArrayList<Item>();
    private int ids = 1;
    private int size = 0;

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean del = index != -1;
        if (del) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items.set(size - 1, null);
            size--;
        }
        return del;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public List<Item> add(Item item) {
        item.setId(ids++);
        items.add(item);
        return items;
    }

    public List<Item> findById(int id) {
        List<Item> rsl = new ArrayList<>();
        int index = indexOf(id);
        if (index != -1) {
            rsl.add(items.get(index));
    }
        return rsl;
}

        public Item[] findByName(String key) {
            int f = 0;
            Item[] result = new Item[size];
            for (int index = 0; index < size; index++) {
                Item item = items.get(index);
                if (item.getName().equals(key)) {
                    result[f++] = item;
                }
            }
            return Arrays.copyOf(result, f);
        }

        public List<Item> findAll() {
            return List.copyOf(items);
        }
}