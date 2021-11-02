package service.Impl;

import Repository.EmployeeRepository;
import Repository.Impl.EmployeeRepositoryImpl;
import bean.Employee;
import service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Employee findById(int id) {
        return null;
    }
}
