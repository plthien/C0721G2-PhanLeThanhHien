package models;


public class Employee extends Person {
    private int degree;
    private int office;
    private double salary;
    private String employeeCode;
    private static int code = 1000;

    public Employee() {
    }

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

    public int getDegree() {
        return this.degree;
    }

    public void setDegree() {
        do {
            try {
                System.out.println("Enter degree: 1. Intermediate\t2. Associate\t3. College\t4. Postgraduate ");
                this.degree = Integer.parseInt(sc.nextLine());
                if (this.degree < 1 || this.degree > 4) {
                    System.out.println("Your choice out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (this.degree < 1 || this.degree > 4);
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

    public int getOffice() {
        return office;
    }

    public void setOffice() {
        do {
            try {
                System.out.println("Enter office: 1. Receptionist\t2. Service Staff\t3. Specialist\t4. Supervisor\t5. Manager\t6. Director ");
                this.office = Integer.parseInt(sc.nextLine());
                if (this.office < 1 || this.office > 6) {
                    System.out.println("Your choice out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (this.office < 1 || this.office > 6);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary() {
        do {
            try {
                System.out.println("Enter salary: ");
                this.salary = Double.parseDouble(sc.nextLine());
                if (this.salary <= 0) {
                    System.out.println("The salary is greater than 0 !");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (this.salary <= 0);
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
                ", BirthDay: " + super.getBirthday() +
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
