package _03_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class GatherArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] array_1 = new int[5];
        int [] array_2 = new int[6];
        int [] array_3 = new int[11];
        System.out.println("Enter The elements of Array_1: ");
        for (int i = 0; i < array_1.length ; i++) {
            System.out.println("Enter the element at position " + (i + 1));
            array_1[i] = sc.nextInt();
        }
        System.out.println("Enter The elements of Array_2: ");
        for (int i = 0; i < array_2.length ; i++) {
            System.out.println("Enter the element at position " + (i + 1));
            array_2[i] = sc.nextInt();
        }
        for (int i = 0; i < array_1.length ; i++) {
            array_3[i] = array_1[i];
        }
        int j = 0;
        for (int i = array_1.length; i < array_3.length ; i++) {
            array_3[i] = array_2[j];
            j++;
        }
        System.out.println("The elements of Array_3: ");
        System.out.println(Arrays.toString(array_3));
    }
}
