package ru.job4j.ood.ocp;

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
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employee>\n")
                .append(String.format("        <name>%s</name>\n", worker.getName()))
                .append(String.format("        <hired>%s</hired>\n", parser.parse(worker.getHired())))
                .append(String.format("        <fired>%s</fired>\n", parser.parse(worker.getHired())))
                .append(String.format("        <salary>%s</salary>\n", worker.getSalary()))
                .append("    </employee>\n")
                .append("    <employee>\n")
                .append(String.format("        <name>%s</name>\n", worker1.getName()))
                .append(String.format("        <hired>%s</hired>\n", parser.parse(worker1.getHired())))
                .append(String.format("        <fired>%s</fired>\n", parser.parse(worker1.getHired())))
                .append(String.format("        <salary>%s</salary>\n", worker1.getSalary()))
                .append("    </employee>\n")
                .append("</employees>\n");
        ReportXML report = new ReportXML(store);
        assertThat(report.generate(employee -> true)).isEqualTo(expected.toString());
    }
}