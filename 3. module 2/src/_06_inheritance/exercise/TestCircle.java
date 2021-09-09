package _06_inheritance.exercise;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setColor("blue");
        circle.setRadius(2.0);
        System.out.println(circle);

        Cylinder cylinder = new Cylinder();
        cylinder.setHigh(8.0);
        cylinder.setColor("red");
        cylinder.setRadius(2.0);
        System.out.println(cylinder);
    }
}
