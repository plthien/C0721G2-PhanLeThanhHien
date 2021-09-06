package _04_class_object.exercise;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public boolean checkA() {
        return this.getA() == 0;
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt(this.getDiscriminant())) / (2 * a);
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt(this.getDiscriminant())) / (2 * a);
    }
    public String checkDiscriminant() {
        if (this.getDiscriminant() > 0) {
            return "The equation has two roots are " + this.getRoot1() + " and " + this.getRoot2();
        } else if (this.getDiscriminant() == 0) {
            return "The equation has one root is " + this.getRoot1();
        } else {
            return "The equation has no real roots ";
        }
    }
}
