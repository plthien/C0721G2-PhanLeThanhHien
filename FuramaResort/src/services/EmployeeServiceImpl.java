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

    public static void displayEmployeeList() {
        for (Person person : employee) {
            System.out.println(person.toString());
        }
    }

    public static void addNewEmployee() {
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
        displayEmployeeList();

    }

    public static void editEmployee(String employeeCode) {
        boolean flag = true;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getEmployeeCode().contains(employeeCode)) {
                System.out.println(employee.get(i).toString());
                employee.remove(employee.get(i));
                addNewEmployee();
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Employee does not exist");
        }
    }


}
