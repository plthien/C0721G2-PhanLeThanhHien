package _04_class_object.practice;

import java.util.Scanner;

public class RectangleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the width: ");
        double width = sc.nextDouble();
        System.out.println("Enter the height: ");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(width,height);
        System.out.println("Your Rectangle: \n" + rectangle.display());
        System.out.println("Perimeter of The rectangle: " + rectangle.getPerimeter());
        System.out.println("Area of The rectangle: " + rectangle.getArea());
    }
}
