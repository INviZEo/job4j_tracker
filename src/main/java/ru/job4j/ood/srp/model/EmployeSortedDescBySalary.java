package ru.job4j.ood.srp.model;

import java.util.Comparator;

public class EmployeSortedDescBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee left, Employee right) {
        return Double.compare(right.getSalary(), left.getSalary());
    }
}
