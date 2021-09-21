package _14_sort_algorithm.exercise;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {4,2,3,6,1,10,8,9};
        insertionSort(array);

    }

    public static void insertionSort(int[] array){
        System.out.println("Before sort: ");
        System.out.println(Arrays.toString(array));

        for (int i = 1; i < array.length ; i++) {
            int temp = array[i];
            int pos = i;
            while (pos > 0 && temp < array[pos-1]){
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = temp;
        }
        System.out.println("After sorted: ");
        System.out.println(Arrays.toString(array));

    }
}
