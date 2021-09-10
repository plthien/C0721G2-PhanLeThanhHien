package _06_inheritance.practice;

import _07_abstract_interface.exercise.Resizeable;

public class Shape implements Resizeable {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of " +this.getColor() + " and " + (this.getFilled() ? "filled" : "not filled");
    }

    @Override
    public void resize(double percent) {
    }
}

