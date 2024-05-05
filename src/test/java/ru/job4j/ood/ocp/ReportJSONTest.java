package ru.job4j.ood.ocp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ReportJSONTest {

    @Test
    public void testJSON() {
        MemoryStore store = new MemoryStore();
        Gson gson = new GsonBuilder().create();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportJSON reportJSON = new ReportJSON(store, parser, new GsonBuilder());
        StringBuilder expected = new StringBuilder().append("{")
                .append("\"Name\"").append(":\"")
                .append(worker.getName()).append("\",")
                .append("\"Hired\"").append(":\"")
                .append(parser.parse(worker.getHired())).append("\",")
                .append("\"Fired\"").append(":\"")
                .append(parser.parse(worker.getFired())).append("\",")
                .append("\"Salary\"").append(":\"")
                .append(worker.getSalary()).append("\"")
                .append("}")
                .append(System.lineSeparator());
        gson.toJson(expected);
        assertThat(reportJSON.generate(employee -> true)).isEqualTo(expected);
    }
}