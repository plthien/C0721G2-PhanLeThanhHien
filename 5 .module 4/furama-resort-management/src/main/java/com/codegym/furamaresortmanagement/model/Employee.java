package com.codegym.furamaresortmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity(name = "employees")
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Min(value = 0)
    private double salary;
    @ManyToOne(targetEntity = EmployeeOffice.class)
    private EmployeeOffice employeeOffice;
    @ManyToOne(targetEntity = EmployeeDegree.class)
    private EmployeeDegree employeeDegree;
    @ManyToOne(targetEntity = EmployeeDepartment.class)
    private EmployeeDepartment employeeDepartment;
    @OneToOne(targetEntity = User.class)
    private User user;

    public Employee() {
    }

    public Employee(String name, String birthday, String gender, String personalID, String phoneNumber, String email, String address, int status, int id, @Min(value = 0) double salary, EmployeeOffice employeeOffice, EmployeeDegree employeeDegree, EmployeeDepartment employeeDepartment, User user) {
        super(name, birthday, gender, personalID, phoneNumber, email, address, status);
        this.id = id;
        this.salary = salary;
        this.employeeOffice = employeeOffice;
        this.employeeDegree = employeeDegree;
        this.employeeDepartment = employeeDepartment;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeeOffice getEmployeeOffice() {
        return employeeOffice;
    }

    public void setEmployeeOffice(EmployeeOffice employeeOffice) {
        this.employeeOffice = employeeOffice;
    }

    public EmployeeDegree getEmployeeDegree() {
        return employeeDegree;
    }

    public void setEmployeeDegree(EmployeeDegree employeeDegree) {
        this.employeeDegree = employeeDegree;
    }

    public EmployeeDepartment getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(EmployeeDepartment employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
