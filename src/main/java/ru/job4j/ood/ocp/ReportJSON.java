package ru.job4j.ood.ocp;

import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import java.util.*;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final GsonBuilder gsonBuilder;

    public ReportJSON(Store store, DateTimeParser<Calendar> dateTimeParser, GsonBuilder gsonBuilder) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gsonBuilder = gsonBuilder;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<String> empl = new ArrayList<>();
        for (Employee employee : store.findBy(filter)) {
            empl.add(employee.getName());
            empl.add(dateTimeParser.parse(employee.getHired()));
            empl.add(dateTimeParser.parse(employee.getFired()));
            empl.add(Double.valueOf(employee.getSalary()).toString());
        }
        return gsonBuilder.create().toJson(empl);
    }
}
