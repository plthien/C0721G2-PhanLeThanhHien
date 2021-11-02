package Repository.Impl;

import Repository.EmployeeRepository;
import bean.Employee;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();

        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call get_all_employee()}");
            ResultSet resultSet = callableStatement.executeQuery();

            Employee employee = null;
            while (resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setBirthday(resultSet.getString("birthday"));
                employee.setGender(resultSet.getString("gender"));
                employee.setPersonalID(resultSet.getString("personal_id"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("address"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDegree(resultSet.getString("degree_name"));
                employee.setOffice(resultSet.getString("office_name"));
                employee.setDepartment(resultSet.getString("department_name"));
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeeList;
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
