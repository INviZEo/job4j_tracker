package ru.job4j.collection;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s : students.keySet()) {
            if (s.account().equals(account)) {
                rsl = Optional.of(s);
                break;
            }
        }
        return students.keySet()
                .stream()
                .filter(s -> s.account().equals(account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> std = findByAccount(account);
        if (std.isEmpty()) {
            return Optional.empty();
        }
        return students.get(std.get())
                .stream()
                .filter(student -> student.name().equals(name))
                .findFirst();
    }
}