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

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
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
        store.add(worker);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportXML report = new ReportXML(store, parser, context);
        assertThat(report.generate(employee -> true)).isEqualTo(" ");
    }
}