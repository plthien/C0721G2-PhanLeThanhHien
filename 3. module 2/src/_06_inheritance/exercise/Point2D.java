package _06_inheritance.exercise;

import java.util.Arrays;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;
    private float[] arr = new float[2];

    public Point2D() {

    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.arr[0] = x;
        this.arr[1] = y;
    }

    public float[] getXY(){
        return this.arr;
    }

    @Override
    public String toString() {
        return "Point2D " + "(" + this.getX() + "," +this.getY() + ")" ;
    }
}
