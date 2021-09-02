package _01_introduction_to_java.practice;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Weight (Kg): ");
        float weight = sc.nextFloat();
        System.out.println("Enter Your Height (m): ");
        float height = sc.nextFloat();
        float bmi = weight / (height * height);
        if (bmi >= 30) {
            System.out.println("Obese!");
        } else if (bmi >= 25) {
            System.out.println("OverWeight!");
        } else if (bmi >= 18.5) {
            System.out.println("Normal!");
        } else {
            System.out.println("UnderWeight!");
        }
    }
}
