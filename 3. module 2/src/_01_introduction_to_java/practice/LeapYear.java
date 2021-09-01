package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Year: ");
        int year = sc.nextInt();
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                System.out.println(year + " is a leap Year!");
            } else {
                System.out.println(year + " is not a leap Year!");
            }
        } else {
            if (year % 4 == 0) {
                System.out.println(year + " is a leap Year!");
            } else {
                System.out.println(year + " is not a leap Year!");
            }
        }
    }
}
