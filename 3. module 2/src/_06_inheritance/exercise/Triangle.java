package _06_inheritance.exercise;

import _06_inheritance.practice.Shape;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public boolean isTriangle() {
        return (this.side1 + this.side2 > this.side3 &&
                this.side1 + this.side3 > this.side2 &&
                this.side3 + this.side2 > this.side1);
    }

    public double getPerimeter() {
        return (this.side1 + this.side2 + this.side3);
    }

    public double getArea() {
        double p = this.getPerimeter() / 2;
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    @Override
    public String toString() {
        return "A Triangle width color of " +
                super.getColor() + ", area is: "+
                this.getArea()+", perimeter is " +
                this.getPerimeter();
    }
}
