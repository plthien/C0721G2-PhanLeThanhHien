package _06_inheritance.practice;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);

        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle("indigo", false, 3.5);
        System.out.println(circle);

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle("orange",true,2.3,5.8);
        System.out.println(rectangle);

        Square square = new Square();
        System.out.println(square);

        square = new Square(5.4);
        System.out.println(square);

        square = new Square("blue",false,5.8);
        System.out.println(square);
    }
}
