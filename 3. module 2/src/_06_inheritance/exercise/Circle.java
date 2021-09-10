package _06_inheritance.exercise;

public class Circle {
    private double radius;
    private String color;
    protected double area;

    public Circle() {

    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.area = this.radius * this.radius * Math.PI;

    }

    public String getColor() {
        return this.color;

    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circles width radius = "+this.getRadius() +
                ", area = "+ this.area +
                ", color of " + this.getColor();
    }
}
