package controllers;

import libs.MenuException;
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
        EmployeeService employeeManagement = new EmployeeServiceImpl();
        CustomerService customerManagement = new CustomerServiceImpl();
        FacilityService facilityManagement = new FacilityServiceImpl();
        BookingService bookingManagement = new BookingServiceImpl();
        ContractService contractManagement = new ContractServiceImpl();
        PromotionService promotionManagement = new PromotionServiceImpl();

        String choiceMenuManagement = "";
        do {
            displayMenu(management);
            choiceMenuManagement = sc.nextLine();
            switch (choiceMenuManagement) {
                case "1":
                    String choiceEmployee = "";
                    do {
                        displayMenu(employee);
                        choiceEmployee = sc.nextLine();
                        switch (choiceEmployee) {
                            case "1":
                                employeeManagement.display();
                                break;
                            case "2":
                                employeeManagement.add();
                                break;
                            case "3":
                                System.out.println("Enter employee code: ");
                                String employeeCode = sc.nextLine();
                                employeeManagement.edit(employeeCode);
                                break;
                            default:
                                System.out.println("Choose again!");
                                break;
                        }
                    } while (!choiceEmployee.equals("4"));
                    break;
                case "2":
                    String choiceCustomer = "";
                    do {
                        displayMenu(customer);
                        choiceCustomer = sc.nextLine();
                        switch (choiceCustomer) {
                            case "1":
                                customerManagement.display();
                                break;
                            case "2":
                                customerManagement.add();
                                break;
                            case "3":
                                customerManagement.display();
                                System.out.println("Enter customer code: ");
                                String customerCode = sc.nextLine();
                                customerManagement.edit(customerCode);
                                break;
                            default:
                                System.out.println("Choose again!");
                                break;
                        }
                    } while (!choiceCustomer.equals("4"));
                    break;
                case "3":
                    String choiceFacility = "";
                    do {
                        displayMenu(facility);
                        choiceFacility = sc.nextLine();
                        switch (choiceFacility) {
                            case "1":
                                facilityManagement.display();
                                break;
                            case "2":
                                facilityManagement.add();
                                break;
                            case "3":
                                facilityManagement.displayFacilityMaintenance();
                                break;
                            default:
                                System.out.println("Choose again!");
                        }
                    } while (!choiceFacility.equals("4"));
                    break;
                case "4":
                    String choiceBooking = "";
                    do {
                        displayMenu(booking);
                        choiceBooking = sc.nextLine();
                        switch (choiceBooking) {
                            case "1":
                                bookingManagement.add();
                                break;
                            case "2":
                                bookingManagement.display();
                                break;
                            case "3":
                                contractManagement.add();
                                break;
                            case "4":
                                contractManagement.display();
                                break;
                            case "5":
                                System.out.println("Enter contract number: ");
                                String contractNumber = sc.nextLine();
                                contractManagement.edit(contractNumber);
                                break;
                            default:
                                System.out.println("Choose again!");
                                 break;
                        }
                    } while (!choiceBooking.equals("6"));
                    break;
                case "5":
                    String choicePromotion = "";
                    do {
                        displayMenu(promotion);
                        choicePromotion = sc.nextLine();
                        switch (choicePromotion) {
                            case "1":
                                promotionManagement.displayCustomerInYear();
                                break;
                            case "2":
                                promotionManagement.giveVoucher();
                                break;
                            default:
                                System.out.println("Choose again!");
                        }
                    } while (!choicePromotion.equals("3"));
                    break;
                default:
                    System.out.println("Choose again!");
                    break;
            }
        } while (!choiceMenuManagement.equals("6"));
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
