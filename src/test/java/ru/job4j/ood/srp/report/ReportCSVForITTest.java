package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportCSVForITTest {

    @Test
    public void reportCSV() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Victor", now, now, 75);
        Employee worker2 = new Employee("Karim", now, now, 50);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportCSVForIT report = new ReportCSVForIT(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name;Hired;Fired;Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(parser.parse(worker.getHired())).append(";")
                .append(parser.parse(worker.getFired())).append(";")
                .append(worker.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(parser.parse(worker1.getHired())).append(";")
                .append(parser.parse(worker1.getFired())).append(";")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(parser.parse(worker2.getHired())).append(";")
                .append(parser.parse(worker2.getFired())).append(";")
                .append(worker2.getSalary())
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true)).isEqualTo(expected.toString());
    }
}