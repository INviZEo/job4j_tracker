package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.model.Employee;

import java.text.SimpleDateFormat;

public class EmplDate {

    private String name, hired, fired;
    private double salary;

    public EmplDate(Employee employee) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm");
        name = employee.getName();
        hired = dateFormat.format(employee.getHired().getTime());
        fired = dateFormat.format(employee.getFired().getTime());
        salary = employee.getSalary();
    }
}
