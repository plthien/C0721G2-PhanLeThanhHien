package _06_inheritance.exercise;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the color of triangle: ");
        triangle.setColor(sc.nextLine());
        do {
            System.out.println("Enter the side of triangle a , b , c: ");
            triangle.setSide1(sc.nextDouble());
            triangle.setSide2(sc.nextDouble());
            triangle.setSide3(sc.nextDouble());

            if (triangle.isTriangle()) {
                System.out.println(triangle.toString());
            } else {
                System.out.println("It's not triangle");
            }
        }
        while (!triangle.isTriangle());




    }
}
