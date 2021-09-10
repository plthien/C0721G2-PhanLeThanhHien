package _07_abstract_interface.exercise;

import _06_inheritance.practice.Circle;
import _06_inheritance.practice.Rectangle;
import _06_inheritance.practice.Shape;
import _06_inheritance.practice.Square;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(4.0);
        shapes[1] = new Rectangle(5, 8);
        shapes[2] = new Square(3);
        shapes[3] = new Rectangle(2, 4);

        System.out.println(" The Area: ");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println((((Circle) shape).getArea()));
            } else if (shape instanceof Square) {
                System.out.println(((Square) shape).getArea());
                ((Square) shape).howToColor();
            } else if (shape instanceof Rectangle) {
                System.out.println(((Rectangle) shape).getArea());

            }
        }
    }
}
