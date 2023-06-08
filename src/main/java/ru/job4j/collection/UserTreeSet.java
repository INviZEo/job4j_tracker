package ru.job4j.collection;

import java.util.Objects;

public class UserTreeSet implements Comparable<UserTreeSet>{
    private String name;
    private int age;

    public UserTreeSet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(UserTreeSet o) {
        int result = this.name.compareTo(o.name);
        return result == 0 ? Integer.compare(this.age, o.age) : result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserTreeSet userTreeSet = (UserTreeSet) o;
        return age == userTreeSet.age && Objects.equals(name, userTreeSet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
