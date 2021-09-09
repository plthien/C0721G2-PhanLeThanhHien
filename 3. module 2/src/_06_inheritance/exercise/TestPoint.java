package _06_inheritance.exercise;

public class TestPoint {
    public static void main(String[] args) {
        MoveablePoint point = new MoveablePoint(1,2,1, 1);
        System.out.println(point);

        System.out.println("Move Point to:");
        System.out.println(point.move());

        System.out.println("Set speed for x.Speed = 2, y.Speed = 2 ");
        point.setxSpeed(2);
        point.setySpeed(2);

        System.out.println("Move Point to:");
        System.out.println(point.move());




    }
}
