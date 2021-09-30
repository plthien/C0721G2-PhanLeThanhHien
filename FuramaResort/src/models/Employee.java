package models;


public class Employee extends Person {
    private int degree;
    private int office;
    private double salary;
    private String employeeCode;
    private static int code = 1000;


    public Employee(String name, String birthDay, boolean gender, String personalID, String phoneNumber,
                    String email, int degree, int office, double salary) {
        super(name, birthDay, gender, personalID, phoneNumber, email);
        this.degree = degree;
        this.office = office;
        this.salary = salary;
    }

    public String getStringDegree() {
        switch (this.degree) {
            case 1:
                return "Intermediate";
            case 2:
                return "Associate";
            case 3:
                return "College";
            case 4:
                return "Postgraduate";
            default:
                return "";
        }
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getStringOffice() {
        switch (this.office) {
            case 1:
                return "Receptionist";
            case 2:
                return "Service Staff";
            case 3:
                return "Specialist";
            case 4:
                return "Supervisor";
            case 5:
                return "Manager";
            case 6:
                return "Director";
            default:
                return "";
        }
    }

    public int getDegree() {
        return degree;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
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

    public void setEmployeeCode() {
        code++;
        this.employeeCode = this.office + "" + this.degree + code;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public static void setCode(int nextCode) {
        code = nextCode;
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
                ", Degree: " + this.getStringDegree() +
                ", Office: " + this.getStringOffice() +
                ", Salary: " + this.getSalary() + '}';
    }

    @Override
    public String getInfoToWrite() {
        return super.getInfoToWrite() + "," + this.degree + "," + this.office + "," + this.salary + "," + this.employeeCode + "," + code;
    }

}
