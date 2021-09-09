package _04_class_object.exercise;


public class FanMain {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setOn(true);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setSpeed(Fan.FAST);
        System.out.println(fan1.toString());
        fan2.setOn(false);
        fan2.setRadius(5);
        fan2.setColor("Blue");
        fan2.setSpeed(Fan.MEDIUM);
        System.out.println(fan2.toString());
    }


}
