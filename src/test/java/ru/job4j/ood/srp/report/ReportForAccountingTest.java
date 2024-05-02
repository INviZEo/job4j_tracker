package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.EmployeSortedDescBySalary;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ReportForAccountingTest {

    @Test
    public void employeeBySalary() {
        MemoryStore store = new MemoryStore();
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Victor", now, now, 75);
        Employee worker2 = new Employee("Karim", now, now, 50);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportForAccounting report = new ReportForAccounting(store, parser, converter);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.USD, worker.getSalary(), Currency.RUB))
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(parser.parse(worker1.getHired())).append(" ")
                .append(parser.parse(worker1.getFired())).append(" ")
                .append(converter.convert(Currency.USD, worker1.getSalary(), Currency.RUB))
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(parser.parse(worker2.getHired())).append(" ")
                .append(parser.parse(worker2.getFired())).append(" ")
                .append(converter.convert(Currency.USD, worker2.getSalary(), Currency.RUB))
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true)).isEqualTo(expected.toString());
    }
}