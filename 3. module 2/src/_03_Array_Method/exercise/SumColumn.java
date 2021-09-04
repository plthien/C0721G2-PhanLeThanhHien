package _03_Array_Method.exercise;

import java.util.Scanner;

public class SumColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        double [][] array = {
//                {1.1, 2.2, 3.3},
//                {4.4, 5.5, 6.6},
//                {7.7, 8.8, 9.9}
//        };

        double [][] array;
        System.out.println("The size of array: ");
        System.out.println("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.println("Enter the number of cols: ");
        int col = sc.nextInt();
        array = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col ; j++) {
                System.out.println("Enter an element at position " + i + j);
                array[i][j] = sc.nextDouble();
            }
        }
        int colSum;
        do {
            System.out.println("Enter a column that you want to sum (begin from 0): ");
            colSum = sc.nextInt();
            if (colSum < 0 || colSum >= col) {
                System.out.println("This column not exists");
            }
        } while (colSum < 0 || colSum >= col );

        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum+= array[i][colSum];
        }
        System.out.println("The sum of the elements at column " +colSum + " is " + sum);

    }


}
