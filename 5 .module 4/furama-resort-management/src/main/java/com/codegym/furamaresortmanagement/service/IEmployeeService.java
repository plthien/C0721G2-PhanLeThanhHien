package com.codegym.furamaresortmanagement.service;

import com.codegym.furamaresortmanagement.model.Employee;
import com.codegym.furamaresortmanagement.model.EmployeeOffice;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(int page, int size, String sortField, String sortDirection);

    Page<Employee> findEmployeeByKeyword(int page, int size, String sortField, String sortDirection, String keyword);


    Page<Employee> findEmployeeByOfficeId(int page, int size, String sortField, String sortDirection, Integer officeId);
}
