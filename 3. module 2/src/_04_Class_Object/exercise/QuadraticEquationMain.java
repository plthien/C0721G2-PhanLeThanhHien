package _04_class_object.exercise;

import java.util.Scanner;

public class QuadraticEquationMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a , b ,c :");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        while (quadraticEquation.checkA()){
            System.out.println("This is not Quadratic Equation ");
            System.out.println("Enter a again: ");
            a = sc.nextDouble();
            quadraticEquation.setA(a);
        }
        System.out.println(quadraticEquation.checkDiscriminant());

    }
}
