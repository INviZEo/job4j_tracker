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

@Disabled
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
        String separator = System.lineSeparator();
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(separator)
                .append("<employees>")
                .append(System.lineSeparator())
                .append("<employee name=\"")
                .append(worker.getName())
                .append("\" salary=\"")
                .append(worker.getSalary())
                .append("\">")
                .append(System.lineSeparator())
                .append("    <hired>")
                .append(parser.parse(worker.getHired()))
                .append("</hired>")
                .append(System.lineSeparator())
                .append("    <fired>")
                .append(parser.parse(worker.getFired()))
                .append("</fired>")
                .append(System.lineSeparator())
                .append("</employee>")
                .append(System.lineSeparator())
                .append("<employee name=\"")
                .append(worker1.getName())
                .append("\" salary=\"")
                .append(worker1.getSalary())
                .append("\">")
                .append(System.lineSeparator())
                .append("    <hired>")
                .append(parser.parse(worker1.getHired()))
                .append("</hired>")
                .append(System.lineSeparator())
                .append("    <fired>")
                .append(parser.parse(worker1.getFired()))
                .append("</fired>")
                .append(System.lineSeparator())
                .append("</employee>")
                .append(System.lineSeparator())
                .append("</employees>");
        ReportXML report = new ReportXML(store);
        assertThat(report.generate(employee -> true)).contains(expected.toString());
    }
}