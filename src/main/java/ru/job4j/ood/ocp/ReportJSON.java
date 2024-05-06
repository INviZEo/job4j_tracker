package ru.job4j.ood.ocp;

import com.google.gson.Gson;
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
        List<EmplDate> empl = store.findBy(filter).stream().map(EmplDate::new).toList();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(empl);
    }
}
