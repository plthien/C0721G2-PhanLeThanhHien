package _14_sort_algorithm.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertionSortStep {
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
            System.out.println("Get " + temp);
            while (pos > 0 && temp < array[pos-1]){
                System.out.println("Move " +array[pos-1] + " to position " + pos);
                array[pos] = array[pos - 1];
                pos--;
                System.out.println(Arrays.toString(array));
            }
            System.out.println("Inserted "+temp+" into position "+ pos);
            array[pos] = temp;
            System.out.println(Arrays.toString(array));
        }
    }
}
