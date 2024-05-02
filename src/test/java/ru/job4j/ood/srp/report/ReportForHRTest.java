package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.EmployeSortedDescBySalary;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ReportForHRTest {

    @Test
    public void employeeBySalary() {
        MemoryStore store = new MemoryStore();
        Employee worker = new Employee("Ivan", 75);
        Employee worker1 = new Employee("Victor", 50);
        Employee worker2 = new Employee("Karim", 100);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportForHR report = new ReportForHR(store, new EmployeSortedDescBySalary());
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary").append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                    .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary())
                    .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                    .append(System.lineSeparator());
        assertThat(report.generate(employee -> true)).isEqualTo(expected.toString());
    }
}