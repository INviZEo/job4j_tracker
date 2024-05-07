package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

@XmlRootElement(name = "Employee")
public class ReportXML implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private JAXBContext context;

    public ReportXML(Store store, DateTimeParser<Calendar> dateTimeParser, JAXBContext context) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.context = context;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        List<EmplDate> empl = store.findBy(filter).stream().map(EmplDate::new).toList();
        List<EmplDate> formEmpl = new ArrayList<>();
        for (Employee employee : store.findBy(filter)) {
            formEmpl.add(new EmplDate(employee.getName(),
                    dateTimeParser.parse(employee.getHired()),
                    dateTimeParser.parse(employee.getFired()),
                    employee.getSalary()));
        }
        Employees employees = new Employees(formEmpl);
        context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employees, writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return xml;
    }
}
