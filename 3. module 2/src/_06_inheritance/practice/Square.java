package _06_inheritance.practice;

import _07_abstract_interface.exercise.Colorable;

public class Square extends Rectangle implements Colorable {

    public Square() {
        super.setWidth(1.0);
        super.setLength(1.0);
    }

    public Square(double size) {
        super(size, size);
    }

    public Square(String color, boolean filled, double size) {
        super(color, filled, size, size);
    }

    public double getSize() {
        return super.getWidth();
    }

    public void setSize(double size) {
        super.setWidth(size);
        super.setLength(size);
    }

    @Override
    public String toString() {
        return "A Square with side=" + this.getSize() + ", which is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.setSize(this.getSize() + this.getSize() * percent / 100);
    }
    @Override
    public void howToColor(){
        System.out.println("Color all four side");
    }
}
