package ru.job4j.ood.srp.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.EmployeSortedDescBySalary;
import ru.job4j.ood.srp.model.Employee;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MemoryStoreTest {

    @Test
    public void EmployeeOnSalary() {
        MemoryStore store = new MemoryStore();
        Employee worker = new Employee("Ivan", 100);
        Employee worker1 = new Employee("Victor", 75);
        Employee worker2 = new Employee("Karim", 50);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        List<Employee> sortedEmployees = store.findBy(employee -> true);
        sortedEmployees.sort(new EmployeSortedDescBySalary());
        assertThat(sortedEmployees)
                .extracting(Employee::getSalary)
                .isSortedAccordingTo(Collections.reverseOrder());
    }
}