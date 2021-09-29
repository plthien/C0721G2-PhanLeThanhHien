package services;

import libs.UserException;
import models.Employee;
import models.Person;
import utils.ReadAndWritePerson;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeServiceImpl implements EmployeeService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_EMPLOYEE_PATH = "src\\data\\employee.csv";

    public void display() {
        ArrayList<Person> employees = ReadAndWritePerson.readFile(FILE_EMPLOYEE_PATH);
        for (Person employee : employees) {
            System.out.println(employee);
        }
    }

    public void add() {
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        String birthday = "";
        boolean check = false;
        do {
            System.out.println("Enter birthday: ");
            birthday = sc.nextLine();
            try {
                check = checkBirthday(birthday);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(check);
        } while (!check);

        System.out.println("Enter gender ( Male enter 'true' else enter 'false'): ");
        boolean gender = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Enter Personal ID: ");
        String personalID = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter degree: 1.Intermediate\t2.Associate\t3.College\t4.Postgraduate ");
        int degree = Integer.parseInt(sc.nextLine());
        System.out.println("Enter office: 1.Receptionist\t2.Service Staff\t3.Specialist\t4.Supervisor\t5.Manager\t6.Director ");
        int office = Integer.parseInt(sc.nextLine());
        System.out.println("Enter salary: ");
        double salary = Double.parseDouble(sc.nextLine());
        Employee employee = new Employee(name, birthday, gender, personalID, phoneNumber, email, degree, office, salary);
        employee.setEmployeeCode();
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(employee);
        ReadAndWritePerson.writeFile(FILE_EMPLOYEE_PATH, personArrayList, true);
        display();

    }

    public void editEmployee(String employeeCode) {
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
                            System.out.println("Enter name: ");
                            String name = sc.nextLine();
                            employees.get(i).setName(name);
                            break;
                        case 2:
                            System.out.println("Enter birthday: ");
                            String birthday = sc.nextLine();
                            employees.get(i).setBirthDay(birthday);
                            break;
                        case 3:
                            System.out.println("Enter gender ( Male enter 'true' else enter 'false'): ");
                            boolean gender = Boolean.parseBoolean(sc.nextLine());
                            employees.get(i).setGender(gender);
                            break;
                        case 4:
                            System.out.println("Enter Personal ID: ");
                            String personalID = sc.nextLine();
                            employees.get(i).setPersonalID(personalID);
                            break;
                        case 5:
                            System.out.println("Enter phone number: ");
                            String phoneNumber = sc.nextLine();
                            employees.get(i).setPhoneNumber(phoneNumber);
                            break;
                        case 6:
                            System.out.println("Enter email: ");
                            String email = sc.nextLine();
                            employees.get(i).setEmail(email);
                            break;
                        case 7:
                            System.out.println("Enter degree: 1.Intermediate\t2.Associate\t3.College\t4.Postgraduate ");
                            int degree = Integer.parseInt(sc.nextLine());
                            ((Employee) employees.get(i)).setDegree(degree);
                            ((Employee) employees.get(i)).setEmployeeCode();
                            break;
                        case 8:
                            System.out.println("Enter office: 1.Receptionist\t2.Service Staff\t3.Specialist\t4.Supervisor\t5.Manager\t6.Director ");
                            int office = Integer.parseInt(sc.nextLine());
                            ((Employee) employees.get(i)).setOffice(office);
                            ((Employee) employees.get(i)).setEmployeeCode();
                            break;
                        case 9:
                            System.out.println("Enter salary: ");
                            double salary = Double.parseDouble(sc.nextLine());
                            ((Employee) employees.get(i)).setSalary(salary);
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

    public boolean checkBirthday(String birthday) throws UserException {
        String regex = "^(?=\\d{2}([\\/])\\d{2}\\/\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birthday);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Birthday is invalid!");
        } else {
            System.out.println(check);
            String[] array = birthday.split("/");
            LocalDate birthdayNew = LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[1]), Integer.parseInt(array[0]));
            LocalDate now = LocalDate.now();
            int age = Period.between(birthdayNew, now).getYears();
            System.out.println(age);
            if (age >= 101 || age <= 17) {
                throw new UserException("Birthday is greater than 17 and less than 101 ");
            }

        }

        return check;
    }


}
