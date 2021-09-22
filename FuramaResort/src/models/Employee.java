package models;



public class Employee extends Person {
    private String degree;
    private String office;
    private double salary;
    private String employeeCode;




    public Employee(String name, String birthDay, boolean gender, String personalID, String phoneNumber,
                    String email, String degree, String office, double salary, String employeeCode) {
        super(name, birthDay, gender, personalID, phoneNumber, email);
        this.degree = degree;
        this.office = office;
        this.salary = salary;
        this.employeeCode = employeeCode;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                " Employee Code: " + this.getEmployeeCode() +
                ", Name: " + super.getName() +
                ", BirthDay: " + super.getBirthDay() +
                ", Gender: " + super.isGender() +
                ", Personal ID: " + super.getPersonalID() +
                ", Phone Number: " + super.getPhoneNumber() +
                ", Email: " + super.getEmail() +
                ", Degree: " + this.getDegree() +
                ", Office: " + this.getOffice() +
                ", Salary: " + this.getSalary() + '}';
    }
}
