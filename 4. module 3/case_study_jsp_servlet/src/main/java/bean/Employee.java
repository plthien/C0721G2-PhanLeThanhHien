package bean;

public class Employee extends Person {
    private double salary;
    private String office;
    private String degree;
    private String department;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String gender, String personalID, String phoneNumber,
                    String email, String address, double salary, String office, String degree, String department) {
        super(id, name, birthday, gender, personalID, phoneNumber, email, address);
        this.salary = salary;
        this.office = office;
        this.degree = degree;
        this.department = department;

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
