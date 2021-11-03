package service;

import bean.Employee;
import bean.EmployeeDegree;
import bean.EmployeeDepartment;
import bean.EmployeeOffice;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    void update(Employee employee);

    void remove(int id);

    Employee findById(int id);
    List<Employee> findByName(String name);

    List<EmployeeDegree> getEmployeeDegree();

    List<EmployeeOffice> getEmployeeOffice();

    List<EmployeeDepartment> getEmployeeDepartment();
}
