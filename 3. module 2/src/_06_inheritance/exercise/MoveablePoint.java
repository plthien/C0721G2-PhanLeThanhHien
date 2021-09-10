package _06_inheritance.exercise;

import java.util.Arrays;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    private float[] arr = new float[2];

    public MoveablePoint() {

    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        arr[0] = xSpeed;
        arr[1] = ySpeed;
    }

    public float[] getSpeed() {
        return this.arr;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," +
                super.getY() + ")" +
                ", speed=(" + this.getxSpeed() +
                "," + this.getySpeed() + ")";
    }

    public MoveablePoint move(){
        super.setX(super.getX() + this.xSpeed);
        super.setY(super.getY() + this.ySpeed);
        return this;

    }
}
