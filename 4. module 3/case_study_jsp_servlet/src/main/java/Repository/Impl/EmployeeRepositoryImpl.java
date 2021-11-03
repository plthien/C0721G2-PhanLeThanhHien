package Repository.Impl;

import Repository.EmployeeRepository;
import bean.Employee;
import bean.EmployeeDegree;
import bean.EmployeeDepartment;
import bean.EmployeeOffice;

import java.sql.*;
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
            EmployeeDegree employeeDegree = null;
            EmployeeOffice employeeOffice = null;
            EmployeeDepartment employeeDepartment = null;
            while (resultSet.next()) {
                employee = new Employee();
                employeeDegree = new EmployeeDegree();
                employeeOffice = new EmployeeOffice();
                employeeDepartment = new EmployeeDepartment();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setBirthday(resultSet.getString("birthday"));
                employee.setGender(resultSet.getString("gender"));
                employee.setPersonalID(resultSet.getString("personal_id"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("address"));
                employee.setSalary(resultSet.getDouble("salary"));

                employeeDegree.setName(resultSet.getString("degree_name"));

                employeeOffice.setName(resultSet.getString("office_name"));

                employeeDepartment.setName(resultSet.getString("department_name"));

                employee.setEmployeeDegree(employeeDegree);
                employee.setEmployeeOffice(employeeOffice);
                employee.setEmployeeDepartment(employeeDepartment);

                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeeList;
    }



    @Override
    public void save(Employee employee) {
        Connection connection = BaseRepository.connection;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee(`name`,birthday," +
                    "gender,personal_id,phone_number,email,salary,address,degree_id,office_id,department_id)" +
                    "values (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setString(4, employee.getPersonalID());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setInt(9, employee.getEmployeeDegree().getId());
            preparedStatement.setInt(10, employee.getEmployeeOffice().getId());
            preparedStatement.setInt(11, employee.getEmployeeDepartment().getId());

            int rowAffect = preparedStatement.executeUpdate();

            if (rowAffect == 1) {
                connection.commit();
                connection.setAutoCommit(true);
            }else {
                connection.rollback();
            }

        } catch (SQLException throwables) {
            try {
                connection.rollback();
                System.out.println(throwables.getMessage());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Employee employee) {
        Connection connection = BaseRepository.connection;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("update employee set `name`=?,birthday=?," +
                    "gender=?,personal_id=?,phone_number=?,email=?,salary=?,address=?,degree_id=?,office_id=?,department_id=? " +
                    "where id=?");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setString(4, employee.getPersonalID());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setInt(9, employee.getEmployeeDegree().getId());
            preparedStatement.setInt(10, employee.getEmployeeOffice().getId());
            preparedStatement.setInt(11, employee.getEmployeeDepartment().getId());
            preparedStatement.setInt(12, employee.getId());

            int rowAffect = preparedStatement.executeUpdate();

            if (rowAffect == 1) {
                connection.commit();
                connection.setAutoCommit(true);
            }else {
                connection.rollback();
            }

        } catch (SQLException throwables) {
            try {
                connection.rollback();
                System.out.println(throwables.getMessage());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(int id) {
        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call delete_employee(?)}");
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        EmployeeDegree employeeDegree =null;
        EmployeeOffice employeeOffice = null;
        EmployeeDepartment employeeDepartment = null;
        try {
            CallableStatement  callableStatement = BaseRepository.connection.prepareCall("{call get_employee_by_id(?)}");
            callableStatement.setInt(1,id);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employeeDegree = new EmployeeDegree();
                employeeOffice = new EmployeeOffice();
                employeeDepartment = new EmployeeDepartment();

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setBirthday(resultSet.getString("birthday"));
                employee.setGender(resultSet.getString("gender"));
                employee.setPersonalID(resultSet.getString("personal_id"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("address"));
                employee.setSalary(resultSet.getDouble("salary"));

                employeeDegree.setId(resultSet.getInt("degree_id"));
                employeeOffice.setId(resultSet.getInt("office_id"));
                employeeDepartment.setId(resultSet.getInt("department_id"));

                employee.setEmployeeDegree(employeeDegree);
                employee.setEmployeeOffice(employeeOffice);
                employee.setEmployeeDepartment(employeeDepartment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee>employeeList = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeeDegree> getEmployeeDegree() {
        List<EmployeeDegree> employeeDegreeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from degree ");
            ResultSet resultSet = preparedStatement.executeQuery();

            EmployeeDegree employeeDegree = null;
            while (resultSet.next()){
                employeeDegree = new EmployeeDegree();
                employeeDegree.setId(resultSet.getInt("id"));
                employeeDegree.setName(resultSet.getString("degree_name"));
                employeeDegreeList.add(employeeDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDegreeList;
    }

    @Override
    public List<EmployeeOffice> getEmployeeOffice() {
        List<EmployeeOffice> employeeOfficeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from office ");
            ResultSet resultSet = preparedStatement.executeQuery();

            EmployeeOffice employeeOffice = null;
            while (resultSet.next()){
                employeeOffice = new EmployeeOffice();
                employeeOffice.setId(resultSet.getInt("id"));
                employeeOffice.setName(resultSet.getString("office_name"));
                employeeOfficeList.add(employeeOffice);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeOfficeList;
    }

    @Override
    public List<EmployeeDepartment> getEmployeeDepartment() {
        List<EmployeeDepartment> employeeDepartmentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from department ");
            ResultSet resultSet = preparedStatement.executeQuery();

            EmployeeDepartment employeeDepartment = null;
            while (resultSet.next()){
                employeeDepartment = new EmployeeDepartment();
                employeeDepartment.setId(resultSet.getInt("id"));
                employeeDepartment.setName(resultSet.getString("department_name"));
                employeeDepartmentList.add(employeeDepartment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDepartmentList;
    }
}
