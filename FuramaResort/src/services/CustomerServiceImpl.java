package services;

import models.Customer;


import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    private static LinkedList<Customer> customers = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    static {
        customers.add(new Customer("Nguyen Minh Tam","20/10/1990",false,"2010123456",
                "078654321","minhtam@gmail.com","Member","Ha Noi","Me0001"));
        customers.add(new Customer("Ho Van Hung","28/02/1995",true,"201710995",
                "0935327645","vahung@gmail.com","Gold","Da Nang","Go0001"));
    }

    public static void displayCustomerList() {
        for (Customer customer:customers) {
            System.out.println(customer.toString());
        }
    }

    public static void addNewCustomer() {
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
        System.out.println("Enter customer types: ");
        String customerTypes = sc.nextLine();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        System.out.println("Enter customer code: ");
        String customerCode = sc.nextLine();
        customers.add(new Customer(name,birthday,gender,personalID,phoneNumber,email,customerTypes,address,customerCode));
        displayCustomerList();

    }

    public static void editCustomer(String customerCode) {
        boolean flag = true;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerCode().contains(customerCode)) {
                int choice;
                do {
                    System.out.println(customers.get(i).toString());
                    System.out.println("Menu: "+
                            "1. Name \t"+
                            "2. Birthday \t"+
                            "3. Gender \t"+
                            "4. Personal ID \t"+
                            "5. Phone number \t"+
                            "6. Email \t"+
                            "7. Customer types \t"+
                            "8. Address \t"+
                            "9. Customer Code \t"+
                            "10. Exit");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice){
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
                            System.out.println("Enter customer types: ");
                            String customerTypes = sc.nextLine();
                            customers.get(i).setCustomerTypes(customerTypes);
                            break;
                        case 8:
                            System.out.println("Enter address: ");
                            String address = sc.nextLine();
                            customers.get(i).setAddress(address);
                            break;
                        case 9:
                            System.out.println("Enter customer code: ");
                            String customerCodeNew = sc.nextLine();
                            customers.get(i).setCustomerCode(customerCodeNew);
                            break;
                    }
                }while (choice != 10);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Customer does not exist");
        }
    }

}
