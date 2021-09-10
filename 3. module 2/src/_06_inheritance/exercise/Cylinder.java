package _06_inheritance.exercise;

public class Cylinder extends Circle {
    private double high;

    public Cylinder() {

    }

    public Cylinder(String color, double radius, double high) {
        super(radius, color);
        this.high = high;
    }

    public double getHigh() {
        return this.high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getVolume() {
        return super.area * this.high;
    }

    @Override
    public String toString() {
        return "A Cylinder with bottom, top are " + super.toString() +
                ", high = " + this.getHigh() +
                ", volume = " + this.getVolume();
    }
}
