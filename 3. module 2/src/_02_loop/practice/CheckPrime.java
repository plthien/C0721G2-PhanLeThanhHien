package _02_loop.practice;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        if (number < 2) {
            System.out.println(number + " is not a prime");
        }else {
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.printf(number + " is a prime");
            } else {
                System.out.println(number + " is not a prime");
            }
        }
    }
}
