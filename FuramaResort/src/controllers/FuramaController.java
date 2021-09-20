package controllers;

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
                "3. Create new constracts",
                "4. Display list contracts",
                "5. Edit contracts",
                "6. Return main menu"
        };
        String[] promotion = new String[]{
                "1. Display list customers use service",
                "2. Display list customers get voucher",
                "3. Return main menu"
        };

        displayMenu(management);
        int choice;

        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayMenu(employee);
                    break;
                case 2:
                    displayMenu(customer);
                    break;
                case 3:
                    displayMenu(facility);
                    break;
                case 4:
                    displayMenu(booking);
                    break;
                case 5:
                    displayMenu(promotion);
                    break;
            }
        } while (choice != 6);
    }

    public static void displayMenu(String[] arr) {
        for (String s : arr) {
            System.out.println(s + "\n");
        }
        System.out.println("Enter your choice: ");
    }

}
