package _04_class_object.exercise;


public class FanMain {
    public static void main(String[] args) {
        final int SLOW = 1;
        final int MEDIUM = 2;
        final int FAST = 3;
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setOn(true);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setSpeed(FAST);
        System.out.println(fan1.toString());
        fan2.setOn(false);
        fan2.setRadius(5);
        fan2.setColor("Blue");
        fan2.setSpeed(MEDIUM);
        System.out.println(fan2.toString());
    }


}
