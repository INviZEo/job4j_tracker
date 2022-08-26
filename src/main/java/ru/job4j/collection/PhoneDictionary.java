package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person d: persons) {
            if (d.getSurname().contains(key)
                    || d.getPhone().contains(key)
                    || d.getAddress().contains(key)
                    || d.getName().contains(key)) {
                result.add(d);
            }
        }
        return result;
    }
}