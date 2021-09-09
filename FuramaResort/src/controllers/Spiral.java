package controllers;

import java.util.Scanner;

public class Spiral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] spiralMatrix = new int[n][n];

        int input = 1;
        int i = 0, j = 0;
        int number = 0;

        do {
            spiralMatrix[i][j] = input;
//            System.out.printf("(%s-%s,%s) %s \n", input, i, j, number);
            input++;
            if (number == 0 && (i + j) == (n - 1)) {
                number = 1;
            } else if (number == 1 && i == j) {
                number = 2;
            } else if (number == 2 && (i + j) == (n - 1)) {
                number = 3;
            } else if (number == 3 && i - j == 1) {
                number = 0;
            }
            switch (number) {
                case 0:
                    j++;
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    j--;
                    break;
                case 3:
                    i--;
                    break;
            }
        } while (input <= (Math.pow(n, 2)));
        for (int a = 0; a < spiralMatrix.length; a++) {
            for (int b = 0; b < spiralMatrix[a].length; b++) {
                System.out.printf("%-4s", spiralMatrix[a][b]);
            }
            System.out.println("");
        }
    }
}
