package services;


import models.Employee;
import models.Person;
import utils.ReadAndWritePerson;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeServiceImpl implements EmployeeService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_EMPLOYEE_PATH = "src\\data\\employee.csv";

    public void display() {
        ArrayList<Person> employees = ReadAndWritePerson.readFile(FILE_EMPLOYEE_PATH);
        if (employees.size() == 0) {
            System.out.println("The employee list is empty");
        } else {
            for (int i = 0; i < employees.size(); i++) {
                System.out.println((i + 1) + ". " + employees.get(i));
            }
        }

    }

    public void add() {
        ReadAndWritePerson.readFile(FILE_EMPLOYEE_PATH);// read file to get nextcode to generate customerCode
        Employee employee = new Employee();
        employee.setName();
        employee.setBirthday();
        employee.setGender();
        employee.setPersonalID();
        employee.setPhoneNumber();
        employee.setEmail();
        employee.setDegree();
        employee.setOffice();
        employee.setSalary();
        employee.setEmployeeCode();
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(employee);
        ReadAndWritePerson.writeFile(FILE_EMPLOYEE_PATH, personArrayList, true);
        display();
    }

    public void edit(String employeeCode) {
        ArrayList<Person> employees = ReadAndWritePerson.readFile(FILE_EMPLOYEE_PATH);
        boolean flag = true;
        for (int i = 0; i < employees.size(); i++) {
            if (((Employee) employees.get(i)).getEmployeeCode().contains(employeeCode)) {
                int choice;
                do {
                    System.out.println(employees.get(i));
                    System.out.println("Menu: " +
                            "1. Name \t" +
                            "2. Birthday \t" +
                            "3. Gender \t" +
                            "4. Personal ID \t" +
                            "5. Phone number \t" +
                            "6. Email \t" +
                            "7. Degree \t" +
                            "8. Office \t" +
                            "9. Salary \t" +
                            "10. Exit");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            employees.get(i).setName();
                            break;
                        case 2:
                            employees.get(i).setBirthday();
                            break;
                        case 3:
                            employees.get(i).setGender();
                            break;
                        case 4:
                            employees.get(i).setPersonalID();
                            break;
                        case 5:
                            employees.get(i).setPhoneNumber();
                            break;
                        case 6:
                            employees.get(i).setEmail();
                            break;
                        case 7:
                            ((Employee) employees.get(i)).setDegree();
                            ((Employee) employees.get(i)).setEmployeeCode();
                            break;
                        case 8:
                            ((Employee) employees.get(i)).setOffice();
                            ((Employee) employees.get(i)).setEmployeeCode();
                            break;
                        case 9:
                            ((Employee) employees.get(i)).setSalary();
                            break;
                    }
                } while (choice != 10);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Employee does not exist");
        } else {
            ReadAndWritePerson.writeFile(FILE_EMPLOYEE_PATH, employees, false);
        }
    }

    @Override
    public void delete() {
        //bo sung sau
    }
}
