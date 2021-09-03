package _03_Array_Method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The length of array: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the element at position " + (i + 1));
            array[i] = sc.nextInt();
        }
        int min = array[0];
        for (int e : array) {
            if (min > e) {
                min = e;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("The smallest element in Array is " + min);
    }
}
