package _03_Array_Method.practice;

import java.util.Scanner;

public class CountStudentsPassing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float [] array;
        int size;
        do {
            System.out.println("Enter The number of students: ");
            size = sc.nextInt();
            if (size > 30 || size <= 0) {
                System.out.println("The number of students not exceed 30");
            }
        } while (size > 30 || size <= 0);
        array = new float[size];
        for (int i = 0; i < size; i++) {
            do {
                System.out.println("Enter a mark for student " + (i +1) +":");
                array[i] = sc.nextFloat();
                if (array[i] > 10 || array[i] < 0) {
                    System.out.println("The mark less than or equal to 10 and greater than or equal to 0 ");
                }
            } while (array[i] > 10 || array[i] < 0);
        }
        int count =0;
        for (int i = 0; i < size ; i++) {
            if (array[i] > 5) {
                count++;
            }
        }
        System.out.println("The number of Students passing the exam is " +count);
    }
}
