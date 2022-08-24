package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Lev");
        names.add("Leyla");
        names.add("Stanislav");
        for (String d : names) {
            System.out.println(d);
        }
    }
}
