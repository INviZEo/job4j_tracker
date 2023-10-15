package ru.job4j.collection;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> pName = x -> x.getName().contains(key);
        Predicate<Person> pSyn = x -> x.getSurname().contains(key);
        Predicate<Person> pPhone = x -> x.getPhone().contains(key);
        Predicate<Person> pAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = pName.or(pSyn).or(pPhone).or(pAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
