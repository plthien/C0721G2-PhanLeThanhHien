package _03_Array_Method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount of rows in Matrix: ");
        int row = sc.nextInt();
        System.out.println("Enter amount of cols in Matrix: ");
        int col = sc.nextInt();
        int [][] array = new int[row][col];
        System.out.println("Enter the elements in Matrix" );
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                System.out.println("Enter the element at position " + i + j);
                array[i][j] = sc.nextInt();
            }
        }
        int max = array[0][0];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println("The largest element in Matrix is: " + max);
    }
}
