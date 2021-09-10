package _07_abstract_interface.exercise;

import _06_inheritance.practice.Circle;
import _06_inheritance.practice.Rectangle;
import _06_inheritance.practice.Shape;
import _06_inheritance.practice.Square;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2.0);
        shapes[1] = new Rectangle(2, 4);
        shapes[2] = new Square(5);


        System.out.println("Area before resize: ");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println((((Circle) shape).getArea()));
            } else if (shape instanceof Rectangle) {
                System.out.println(((Rectangle) shape).getArea());
            }
        }

        System.out.println("Area after resize: ");
        for (Shape shape : shapes) {
            shape.resize(Math.round(Math.random() * 100));
            if (shape instanceof Circle) {
                System.out.println((((Circle) shape).getArea()));
            } else if (shape instanceof Rectangle) {
                System.out.println(((Rectangle) shape).getArea());
            }
        }

    }
}
