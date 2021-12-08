package com.codegym.furamaresortmanagement.model.employee;

import com.codegym.furamaresortmanagement.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "employees")
@Data @AllArgsConstructor @NoArgsConstructor
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Min(0)
    private double salary;
    @ManyToOne(targetEntity = EmployeeOffice.class)
    private EmployeeOffice employeeOffice;
    @ManyToOne(targetEntity = EmployeeDegree.class)
    private EmployeeDegree employeeDegree;
    @ManyToOne(targetEntity = EmployeeDepartment.class)
    private EmployeeDepartment employeeDepartment;
    @OneToOne(targetEntity = User.class)
    private User user;

}
