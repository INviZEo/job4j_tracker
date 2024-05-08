package ru.job4j.ood.ocp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ReportXMLTest {

    @Test
    public void testXML() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        JAXBContext context = JAXBContext.newInstance(EmplDate.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("David", now, now, 300);
        store.add(worker);
        store.add(worker1);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        List<String> expected = List.of("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>",
                "<employees>",
                "<employee name=\"" + worker.getName() + "\" " + "salary=\"" + worker.getSalary() + "\">",
                "<hired>" + parser.parse(worker.getHired()) + "</hired>",
                "<fired>" + parser.parse(worker.getFired()) + "</fired>",
                "</employee>",
                "<employee name=\"" + worker1.getName() + "\" " + "salary=\"" + worker1.getSalary() + "\">",
                "<hired>" + parser.parse(worker1.getHired()) + "</hired>",
                "<fired>" + parser.parse(worker1.getFired()) + "</fired>",
                "</employee>",
                "</employees>");
        ReportXML report = new ReportXML(store);
        assertThat(report.generate(employee -> true)).contains(expected);
    }
}