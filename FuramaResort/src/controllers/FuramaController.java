package controllers;

import services.*;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] management = new String[]{
                "1. Employee Management",
                "2. Customer Management",
                "3. Facility Management",
                "4. Booking Management",
                "5. Promotion Management",
                "6. Exit"
        };
        String[] employee = new String[]{
                "1. Display list employees",
                "2. Add new employee",
                "3. Edit employee",
                "4. Return main menu"
        };
        String[] customer = new String[]{
                "1. Display list customers",
                "2. Add new customer",
                "3. Edit customer",
                "4. Return main menu"
        };
        String[] facility = new String[]{
                "1. Display list facility",
                "2. Add new facility",
                "3. Display list facility maintenance",
                "4. Return main menu"
        };
        String[] booking = new String[]{
                "1. Add new booking",
                "2. Display list booking",
                "3. Create new contracts",
                "4. Display list contracts",
                "5. Edit contracts",
                "6. Return main menu"
        };
        String[] promotion = new String[]{
                "1. Display list customers use service",
                "2. Display list customers get voucher",
                "3. Return main menu"
        };
        EmployeeServiceImpl employeeManage = new EmployeeServiceImpl();
        CustomerServiceImpl customerManage = new CustomerServiceImpl();
        FacilityServiceImpl facilityManage = new FacilityServiceImpl();
        BookingServiceImpl bookingManage = new BookingServiceImpl();
        ContractServiceImpl contractManage = new ContractServiceImpl();

        int choiceMenuManagement;
        do {
            displayMenu(management);
            choiceMenuManagement = Integer.parseInt(sc.nextLine());
            switch (choiceMenuManagement) {
                case 1:
                    int choiceEmployee;
                    do {
                        displayMenu(employee);
                        choiceEmployee = Integer.parseInt(sc.nextLine());
                        switch (choiceEmployee) {
                            case 1:
                                employeeManage.display();
                                break;
                            case 2:
                                employeeManage.add();
                                break;
                            case 3:
                                System.out.println("Enter employee code: ");
                                String employeeCode = sc.nextLine();
                                employeeManage.editEmployee(employeeCode);
                                break;
                        }
                    } while (choiceEmployee!=4);
                    break;
                case 2:
                    int choiceCustomer;
                    do {
                        displayMenu(customer);
                        choiceCustomer= Integer.parseInt(sc.nextLine());
                        switch (choiceCustomer) {
                            case 1:
                                customerManage.display();
                                break;
                            case 2:
                                customerManage.add();
                                break;
                            case 3:
                                System.out.println("Enter customer code: ");
                                String customerCode = sc.nextLine();
                                customerManage.editCustomer(customerCode);
                                break;
                        }
                    } while (choiceCustomer!=4);
                    break;
                case 3:
                    int choiceFacility;
                    do {
                        displayMenu(facility);
                        choiceFacility= Integer.parseInt(sc.nextLine());
                        switch (choiceFacility) {
                            case 1:
                                facilityManage.display();
                                break;
                            case 2:
                                facilityManage.add();
                                break;
                            case 3:
                                facilityManage.displayFacilityMaintenance();
                                break;
                        }
                    } while (choiceFacility!=4);
                    break;
                case 4:
                    int choiceBooking;
                    do {
                        displayMenu(booking);
                        choiceBooking= Integer.parseInt(sc.nextLine());
                        switch (choiceBooking) {
                            case 1:
                                customerManage.display();
                                facilityManage.display();
                                bookingManage.add();
                                break;
                            case 2:
                                bookingManage.display();
                                break;
                            case 3:
                                contractManage.add();
                                break;
                            case 4:
                                contractManage.display();
                        }
                    } while (choiceBooking!=6);
                    break;
                case 5:
                    displayMenu(promotion);
                    break;
            }
        } while (choiceMenuManagement != 6);
    }

    public static void displayMenu(String[] arr) {
        System.out.println("----------------------------------------");
        System.out.println("Menu: ");
        for (String s : arr) {
            System.out.print(s + "\t");
        }
        System.out.print("\nEnter your choice: ");
    }

}
