package ru.job4j.ood.srp.model;

import ru.job4j.ood.ocp.EmplDate;

import javax.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement
public class Employees {
    @XmlElement
    private List<EmplDate> employees;

    public Employees() {
    }

    public Employees(List<EmplDate> employees) {
        this.employees = employees;
    }
}
