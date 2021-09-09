package _06_inheritance.exercise;

import java.util.Arrays;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();

        point2D.setX(4);
        point2D.setY(5);
        System.out.println(point2D);

        point2D = new Point2D(6, 7);
        System.out.println(point2D);

        point2D.setXY(1, 2);
        System.out.println(Arrays.toString(point2D.getXY()));

        Point3D point3D = new Point3D();

        point3D.setX(2);
        point3D.setY(3);
        point3D.setZ(4);
        System.out.println(point3D);

        point3D.setXYZ(5,6,7);
        System.out.println(Arrays.toString(point3D.getXYZ()));

    }
}
