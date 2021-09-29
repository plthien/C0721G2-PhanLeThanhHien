package services;

import models.Customer;
import models.Person;
import sun.nio.cs.ext.ISO2022_CN;
import utils.ReadAndWritePerson;


import java.util.ArrayList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_CUSTOMER_PATH = "src\\data\\customer.csv";


    public ArrayList<String> display() {
        ArrayList<Person> customers = ReadAndWritePerson.readFile(FILE_CUSTOMER_PATH);
        ArrayList<String> customerCodeList = new ArrayList<>();
        System.out.println("Customer List: ");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i));
            customerCodeList.add(((Customer) customers.get(i)).getCustomerCode());
        }
        return customerCodeList;
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
        System.out.println("Enter customer types:: 1.Member\t2.Silver\t3.Gold\t4.Platinium\t5.Diamond ");
        int customerTypes = Integer.parseInt(sc.nextLine());
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        Customer customer = new Customer(name, birthday, gender, personalID, phoneNumber, email, customerTypes, address);
        customer.setCustomerCode();
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(customer);
        ReadAndWritePerson.writeFile(FILE_CUSTOMER_PATH, personArrayList, true);
        display();

    }

    public void editCustomer(String customerCode) {
        ArrayList<Person> customers = ReadAndWritePerson.readFile(FILE_CUSTOMER_PATH);
        boolean flag = true;
        for (int i = 0; i < customers.size(); i++) {
            if (((Customer) customers.get(i)).getCustomerCode().contains(customerCode)) {
                int choice;
                do {
                    System.out.println(customers.get(i));
                    System.out.println("Menu: " +
                            "1. Name \t" +
                            "2. Birthday \t" +
                            "3. Gender \t" +
                            "4. Personal ID \t" +
                            "5. Phone number \t" +
                            "6. Email \t" +
                            "7. Customer types \t" +
                            "8. Address \t" +
                            "9. Exit");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Enter name: ");
                            String name = sc.nextLine();
                            customers.get(i).setName(name);
                            break;
                        case 2:
                            System.out.println("Enter birthday: ");
                            String birthday = sc.nextLine();
                            customers.get(i).setBirthDay(birthday);
                            break;
                        case 3:
                            System.out.println("Enter gender ( Male enter 'true' else enter 'false'): ");
                            boolean gender = Boolean.parseBoolean(sc.nextLine());
                            customers.get(i).setGender(gender);
                            break;
                        case 4:
                            System.out.println("Enter Personal ID: ");
                            String personalID = sc.nextLine();
                            customers.get(i).setPersonalID(personalID);
                            break;
                        case 5:
                            System.out.println("Enter phone number: ");
                            String phoneNumber = sc.nextLine();
                            customers.get(i).setPhoneNumber(phoneNumber);
                            break;
                        case 6:
                            System.out.println("Enter email: ");
                            String email = sc.nextLine();
                            customers.get(i).setEmail(email);
                            break;
                        case 7:
                            System.out.println("Enter customer types:: 1.Member\t2.Silver\t3.Gold\t4.Platinium\t5.Diamond ");
                            int customerTypes = Integer.parseInt(sc.nextLine());
                            ((Customer) customers.get(i)).setCustomerTypes(customerTypes);
                            ((Customer) customers.get(i)).setCustomerCode();
                            break;
                        case 8:
                            System.out.println("Enter address: ");
                            String address = sc.nextLine();
                            ((Customer) customers.get(i)).setAddress(address);
                            break;
                    }
                } while (choice != 9);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Customer does not exist");
        } else {
            ReadAndWritePerson.writeFile(FILE_CUSTOMER_PATH, customers, false);
        }
    }

}
