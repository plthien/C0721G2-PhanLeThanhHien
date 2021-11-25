package com.codegym.furamaresortmanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employee_office")
public class EmployeeOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "employeeOffice")
    private List<Employee> employeeList;

    public EmployeeOffice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
