package _03_Array_Method.exercise;

import java.util.Scanner;

public class SumDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        double [][] array = {
//                {1.1, 2.2, 3.3},
//                {4.4, 5.5, 6.6},
//                {7.7, 8.8, 9.9}
//        };
        double [][] array;
        int size;
        do {
            System.out.println("Enter the size of The square matrix: ");
            size = sc.nextInt();
            if (size < 2) {
                System.out.println("This matrix is not The square matrix ");
            }
        } while (size < 2);
        array = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Enter an element at position " +i+j +" : ");
                array[i][j] = sc.nextDouble();
            }
        }
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        System.out.println("The sum of the elements on the main diagonal is " + sum);
    }
}
