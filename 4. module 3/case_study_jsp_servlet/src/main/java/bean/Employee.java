package bean;

public class Employee extends Person {
    private double salary;
    private EmployeeOffice employeeOffice;
    private EmployeeDegree employeeDegree;
    private EmployeeDepartment employeeDepartment;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String gender, String personalID, String phoneNumber, String email, String address, double salary, EmployeeOffice employeeOffice, EmployeeDegree employeeDegree, EmployeeDepartment employeeDepartment) {
        super(id, name, birthday, gender, personalID, phoneNumber, email, address);
        this.salary = salary;
        this.employeeOffice = employeeOffice;
        this.employeeDegree = employeeDegree;
        this.employeeDepartment = employeeDepartment;
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
}
