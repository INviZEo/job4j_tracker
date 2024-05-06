package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private JAXBContext context;

    public ReportXML(Store store, DateTimeParser<Calendar> dateTimeParser, JAXBContext context) throws JAXBException {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.context = context;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        List<EmplDate> empl = store.findBy(filter).stream().map(EmplDate::new).toList();
        context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new EmplDate((Employee) empl), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return xml;
    }
}
