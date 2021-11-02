package Repository;

import bean.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();

    void save(Employee employee);

    void update(Employee employee);

    void remove(int id);

    Employee findById(int id);

}
