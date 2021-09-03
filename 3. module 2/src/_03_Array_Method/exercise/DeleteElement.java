package _03_Array_Method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int [] array = {0,1,4,4,3,5,4,7};
        int size =array.length;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an element: ");
        int element = sc.nextInt();
        for (int i = 0; i < size ; i++) {
            if (array[i] == element) {
                for (int j = i; j < size - 1 ; j++) {
                    array[j] = array[j + 1];
                }
                i--;
                size--;
            }
        }
        System.out.println("Array after delete element: ");
        for (int i = 0; i < size ; i++) {
            System.out.print(array[i] + "\t");
        }

    }
}
