package _02_loop.exercise;

import java.util.Scanner;

public class DisplayShape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu: ");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        while (choice != 4) {
            switch (choice) {
                case 1: {
                    System.out.println("Enter the width: ");
                    int width = sc.nextInt();
                    System.out.println("Enter the length: ");
                    int length = sc.nextInt();
                    for (int i = 1; i <= width; i++) {
                        for (int j = 1; j <= length; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the high: ");
                    int high = sc.nextInt();
                    for (int i = 1; i <= high; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the high:");
                    int high = sc.nextInt();
                    for (int row = 1; row <= high; row++) {
                        for (int i = 1; i <= (high - row); i++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= (row * 2 - 1); j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                }
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");

            }
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
        }
    }
}
