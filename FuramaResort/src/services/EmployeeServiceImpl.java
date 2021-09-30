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
        if (employees.size() == 0) {
            System.out.println("The employee list is empty");
        } else {
            for (int i = 0; i < employees.size() ; i++) {
                System.out.println((i+1) + ". " +employees.get(i));
            }
        }

    }

    public void add() {
        ReadAndWritePerson.readFile(FILE_EMPLOYEE_PATH);// read file to get nextcode to generate customerCode
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
        } while (!check);

        boolean gender = true;
        int choiceGender = 0;
        do {
            try {
                System.out.println("Enter gender: 1. Male\t2. Female ");
                choiceGender = Integer.parseInt(sc.nextLine());
                if (choiceGender == 2) {
                    gender = false;
                } else if (choiceGender != 1) {
                    System.out.println("Your choice out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }

        } while (choiceGender != 1 && choiceGender != 2);

        System.out.println("Enter Personal ID: ");
        String personalID = sc.nextLine();

        String phoneNumber = "";
        check = false;
        do {
            try {
                System.out.println("Enter phone number: ");
                phoneNumber = sc.nextLine();
                check = checkPhoneNumber(phoneNumber);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (!check);

        String email = "";
        check = false;
        do {
            try {
                System.out.println("Enter email: ");
                email = sc.nextLine();
                check = checkEmail(email);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (!check);

        int degree = 1;
        do {
            try {
                System.out.println("Enter degree: 1. Intermediate\t2. Associate\t3. College\t4. Postgraduate ");
                degree = Integer.parseInt(sc.nextLine());
                if (degree < 1 || degree > 4) {
                    System.out.println("Your choice out of range!");
                }
            }catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (degree < 1 || degree > 4);

        int office = 1;
        do {
            try {
                System.out.println("Enter office: 1. Receptionist\t2. Service Staff\t3. Specialist\t4. Supervisor\t5. Manager\t6. Director ");
                office = Integer.parseInt(sc.nextLine());
                if (office < 1 || office > 6) {
                    System.out.println("Your choice out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (office < 1 || office > 6);

        double salary = 0;
        do {
            try {
                System.out.println("Enter salary: ");
                salary = Double.parseDouble(sc.nextLine());
                if (salary <= 0) {
                    System.out.println("The salary is greater than 0 !");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (salary <= 0);

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
                            } while (!check);
                            employees.get(i).setBirthDay(birthday);
                            break;
                        case 3:
                            boolean gender = true;
                            int choiceGender = 0;
                            do {
                                try {
                                    System.out.println("Enter gender: 1. Male\t2. Female ");
                                    choiceGender = Integer.parseInt(sc.nextLine());
                                    if (choiceGender == 2) {
                                        gender = false;
                                    } else if (choiceGender != 1) {
                                        System.out.println("Your choice out of range!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("It is not a number!");
                                }

                            } while (choiceGender != 1 && choiceGender != 2);
                            employees.get(i).setGender(gender);
                            break;
                        case 4:
                            System.out.println("Enter Personal ID: ");
                            String personalID = sc.nextLine();
                            employees.get(i).setPersonalID(personalID);
                            break;
                        case 5:
                            String phoneNumber = "";
                            check = false;
                            do {
                                try {
                                    System.out.println("Enter phone number: ");
                                    phoneNumber = sc.nextLine();
                                    check = checkPhoneNumber(phoneNumber);
                                } catch (UserException e) {
                                    System.out.println(e.getMessage());
                                }
                            } while (!check);
                            employees.get(i).setPhoneNumber(phoneNumber);
                            break;
                        case 6:
                            String email = "";
                            check = false;
                            do {
                                try {
                                    System.out.println("Enter email: ");
                                    email = sc.nextLine();
                                    check = checkEmail(email);
                                } catch (UserException e) {
                                    System.out.println(e.getMessage());
                                }
                            } while (!check);
                            employees.get(i).setEmail(email);
                            break;
                        case 7:
                            int degree = 1;
                            do {
                                try {
                                    System.out.println("Enter degree: 1. Intermediate\t2. Associate\t3. College\t4. Postgraduate ");
                                    degree = Integer.parseInt(sc.nextLine());
                                    if (degree < 1 || degree > 4) {
                                        System.out.println("Your choice out of range!");
                                    }
                                }catch (NumberFormatException e) {
                                    System.out.println("It is not a number!");
                                }
                            } while (degree < 1 || degree > 4);
                            ((Employee) employees.get(i)).setDegree(degree);
                            ((Employee) employees.get(i)).setEmployeeCode();
                            break;
                        case 8:
                            int office = 1;
                            do {
                                try {
                                    System.out.println("Enter office: 1. Receptionist\t2. Service Staff\t3. Specialist\t4. Supervisor\t5. Manager\t6. Director ");
                                    office = Integer.parseInt(sc.nextLine());
                                    if (office < 1 || office > 6) {
                                        System.out.println("Your choice out of range!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("It is not a number!");
                                }
                            } while (office < 1 || office > 6);
                            ((Employee) employees.get(i)).setOffice(office);
                            ((Employee) employees.get(i)).setEmployeeCode();
                            break;
                        case 9:
                            double salary = 0;
                            do {
                                try {
                                    System.out.println("Enter salary: ");
                                    salary = Double.parseDouble(sc.nextLine());
                                    if (salary <= 0) {
                                        System.out.println("The salary is greater than 0 !");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("It is not a number!");
                                }
                            } while (salary <= 0);
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
            String[] array = birthday.split("/");
            LocalDate birthdayNew = LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[1]), Integer.parseInt(array[0]));
            LocalDate now = LocalDate.now();
            int age = Period.between(birthdayNew, now).getYears();
            if (age >= 101 || age <= 17) {
                throw new UserException("Birthday is greater than 17 and less than 101 ");
            }
        }
        return check;
    }

    public boolean checkPhoneNumber(String phoneNumber) throws UserException {
        String regex = "0\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Your phone number is invalid!");
        }
        return check;
    }

    public boolean checkEmail(String email) throws UserException {
        String regex = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Your email is invalid!");
        }
        return check;
    }


}
