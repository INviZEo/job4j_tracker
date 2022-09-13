package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("lev2281488322@gmail.com", "Lev Pasternak");
        for (String d: map.keySet()) {
            String key = map.get(d);
            System.out.println(key);
            System.out.println(d);
        }
    }
}
