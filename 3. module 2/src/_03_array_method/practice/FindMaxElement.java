package _03_array_method.practice;

import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element " + (i + 1) + " : ");
            array[i] = sc.nextInt();
        }
        System.out.println("Property list");
        for (int temp : array) {
            System.out.println(temp + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int i = 1; i < size; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i + 1;
            }
        }
        System.out.println("The largest property value in the list is: " + max + ", at position " + index);

    }
}
