package _04_Class_Object.exercise;

import java.util.Scanner;

public class QuadraticQuationMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b ,c;
        do {
            System.out.print("Enter a , b ,c :");
            a = sc.nextDouble();
            b = sc.nextDouble();
            c = sc.nextDouble();
            if (a == 0) {
                System.out.println("This ");
            }
        }

        QuadraticEquation quadraticEquation = new QuadraticEquation();

    }
}
