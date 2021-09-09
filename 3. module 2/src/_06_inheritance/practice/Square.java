package _06_inheritance.practice;

public class Square extends Rectangle {

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
    public void setWidth(double width) {
        this.setSize(width);
    }
    @Override
    public void setLength(double length){
        this.setSize(length);
    }

    @Override
    public String toString() {
        return "A Square with side="+ this.getSize()+", which is a subclass of " +super.toString();
    }
}
