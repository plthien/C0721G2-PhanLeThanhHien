package _15_exception_debug.exercise;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a , b, c: ");
        double a = sc.nextDouble();
        double b= sc.nextDouble();
        double c= sc.nextDouble();
        try {
            checkTriangle(a,b,c);
        } catch (IllegalTriangleException e){
            System.out.println(e.getMessage());
        }
    }

    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException{
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException(" Exception: The sides is not right");
        } else {
            System.out.println("It's a Triangle");
        }
    }
}
