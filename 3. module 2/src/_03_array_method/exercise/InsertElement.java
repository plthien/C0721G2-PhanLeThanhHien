package _03_aArray_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array;
        System.out.println("Enter the length of Array: ");
        int n = sc.nextInt();
        array = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element at position " + (i + 1) + " : ");
            array[i] = sc.nextInt();
        }
        System.out.println("Enter an element that you want to insert into array: ");
        int e = sc.nextInt();
        int index;
        do {
            System.out.println("Enter the position of that element: ");
            index = sc.nextInt() - 1;
            if (index < 0 || index >= n) {
                System.out.println("Can not insert element into array at position " + (index + 1));
            }
        } while (index < 0 || index >= array.length);
        int i = n;
        while (i > index) {
            array[i] = array[i - 1];
            i--;
        }
        array[index] = e;
        System.out.println(Arrays.toString(array));


    }
}
