package _04_class_object.exercise;

public class Fan {

    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.isOn()) {
            return "Fan is on{" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            return "Fan is off{" +
                    "radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
