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
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ReportJSONTest {

    @Test
    public void testJSON() {
        MemoryStore store = new MemoryStore();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("David", now, now, 300);
        store.add(worker);
        store.add(worker1);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportJSON reportJSON = new ReportJSON(store, parser, new GsonBuilder());
        List<EmplDate> emplDates = store.findBy(employee -> true).stream().map(EmplDate::new).toList();
        String expected = gson.toJson(emplDates);
        assertThat(reportJSON.generate(employee -> true)).isEqualTo((expected));
    }
}