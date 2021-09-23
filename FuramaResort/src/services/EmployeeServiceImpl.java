package services;

import models.Employee;
import models.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static ArrayList<Employee> employee = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static {
        employee.add(new Employee("Tran van Hung", "20/10/1970", true, "201620234", "0905686868",
                "vanHung@gmail.com", "Postgraduate", "Director", 3000, "D0001"));
        employee.add(new Employee("Hoang Thi Quynh", "20/10/1990", false, "201620222", "0905868686",
                "thiQuynh@gmail.com", "College", "Manager", 2000, "M0002"));

    }

    public void display() {
        for (Employee employee : employee) {
            System.out.println(employee.toString());
        }
    }

    public void add() {
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter birthday: ");
        String birthday = sc.nextLine();
        System.out.println("Enter gender ( Male enter 'true' else enter 'false'): ");
        boolean gender = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Enter Personal ID: ");
        String personalID = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter degree: ");
        String degree = sc.nextLine();
        System.out.println("Enter office: ");
        String office = sc.nextLine();
        System.out.println("Enter salary: ");
        double salary = Double.parseDouble(sc.nextLine());
        System.out.println("Enter employee code: ");
        String employeeCode = sc.nextLine();
        employee.add(new Employee(name, birthday, gender, personalID, phoneNumber, email, degree, office, salary, employeeCode));
        display();

    }

    public void editEmployee(String employeeCode) {
        boolean flag = true;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getEmployeeCode().contains(employeeCode)) {
                int choice;
                do {
                    System.out.println(employee.get(i).toString());
                    System.out.println("Menu: "+
                            "1. Name \t"+
                            "2. Birthday \t"+
                            "3. Gender \t"+
                            "4. Personal ID \t"+
                            "5. Phone number \t"+
                            "6. Email \t"+
                            "7. Degree \t"+
                            "8. Office \t"+
                            "9. Salary \t"+
                            "10. Employee Code \t"+
                            "11. Exit");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice){
                        case 1:
                            System.out.println("Enter name: ");
                            String name = sc.nextLine();
                            employee.get(i).setName(name);
                            break;
                        case 2:
                            System.out.println("Enter birthday: ");
                            String birthday = sc.nextLine();
                            employee.get(i).setBirthDay(birthday);
                            break;
                        case 3:
                            System.out.println("Enter gender ( Male enter 'true' else enter 'false'): ");
                            boolean gender = Boolean.parseBoolean(sc.nextLine());
                            employee.get(i).setGender(gender);
                            break;
                        case 4:
                            System.out.println("Enter Personal ID: ");
                            String personalID = sc.nextLine();
                            employee.get(i).setPersonalID(personalID);
                            break;
                        case 5:
                            System.out.println("Enter phone number: ");
                            String phoneNumber = sc.nextLine();
                            employee.get(i).setPhoneNumber(phoneNumber);
                            break;
                        case 6:
                            System.out.println("Enter email: ");
                            String email = sc.nextLine();
                            employee.get(i).setEmail(email);
                            break;
                        case 7:
                            System.out.println("Enter degree: ");
                            String degree = sc.nextLine();
                            employee.get(i).setDegree(degree);
                            break;
                        case 8:
                            System.out.println("Enter office: ");
                            String office = sc.nextLine();
                            employee.get(i).setOffice(office);
                            break;
                        case 9:
                            System.out.println("Enter salary: ");
                            double salary = Double.parseDouble(sc.nextLine());
                            employee.get(i).setSalary(salary);
                            break;
                        case 10:
                            System.out.println("Enter employee code: ");
                            String employeeCodeNew = sc.nextLine();
                            employee.get(i).setEmployeeCode(employeeCodeNew);
                            break;
                    }
                }while (choice != 11);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Employee does not exist");
        }
    }


}
