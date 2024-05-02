package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.EmployeSortedDescBySalary;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.List;
import java.util.function.Predicate;

public class ReportForHR implements Report {

    private final Store store;
    private final EmployeSortedDescBySalary sortedDescBySalary;

    public ReportForHR(Store store, EmployeSortedDescBySalary sortedDescBySalary) {
        this.store = store;
        this.sortedDescBySalary = sortedDescBySalary;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        employees.sort(sortedDescBySalary);
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
