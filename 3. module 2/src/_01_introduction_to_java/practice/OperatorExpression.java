package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class OperatorExpression {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = sc.nextFloat();
        System.out.println("Enter height :");
        height = sc.nextFloat();
        float area = width * height;
        System.out.println("Area is :" +area);
    }
}
