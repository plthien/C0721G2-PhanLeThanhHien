package services;

import models.Customer;
import models.Person;
import utils.ReadAndWritePerson;


import java.util.ArrayList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_CUSTOMER_PATH = "src\\data\\customer.csv";

    public void display() {
        ArrayList<Person> customers = ReadAndWritePerson.readFile(FILE_CUSTOMER_PATH);
        System.out.println("Customer List: ");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i));
        }
    }

    public ArrayList<String> getCustomerCodeList(){
        ArrayList<Person> customers = ReadAndWritePerson.readFile(FILE_CUSTOMER_PATH);
        ArrayList<String> customerCodeList = new ArrayList<>();
        for (Person customer : customers) {
            customerCodeList.add(((Customer) customer).getCustomerCode());
        }
        return customerCodeList;
    }

    public void add() {
        ReadAndWritePerson.readFile(FILE_CUSTOMER_PATH); // read file to get nextcode to generate customerCode
        Customer customer = new Customer();
        customer.setName();
        customer.setBirthday();
        customer.setGender();
        customer.setPersonalID();
        customer.setPhoneNumber();
        customer.setEmail();
        customer.setCustomerTypes();
        customer.setAddress();
        customer.setCustomerCode();
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(customer);
        ReadAndWritePerson.writeFile(FILE_CUSTOMER_PATH, personArrayList, true);
        display();
    }

    public void edit(String customerCode) {
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
                            customers.get(i).setName();
                            break;
                        case 2:
                            customers.get(i).setBirthday();
                            break;
                        case 3:
                            customers.get(i).setGender();
                            break;
                        case 4:
                            customers.get(i).setPersonalID();
                            break;
                        case 5:
                            customers.get(i).setPhoneNumber();
                            break;
                        case 6:
                            customers.get(i).setEmail();
                            break;
                        case 7:
                            ((Customer) customers.get(i)).setCustomerTypes();
                            ((Customer) customers.get(i)).setCustomerCode();
                            break;
                        case 8:
                            ((Customer) customers.get(i)).setAddress();
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

    @Override
    public void delete() {
        //bo sung sau
    }

    @Override
    public Customer searchCustomerByCode(String customerCode){
        ArrayList<Person> customers = ReadAndWritePerson.readFile(FILE_CUSTOMER_PATH);
        for (Person customer:customers) {
            if (((Customer) customer).getCustomerCode().contains(customerCode)){
                return (Customer) customer;
            }
        }
        return null;
    }

}
