package _03_Array_Method.practice;

import java.util.Scanner;

public class FindValueInArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a name's student:");
        String inputName = sc.nextLine();
        boolean flag = true;
        for (int i = 0; i <students.length ; i++) {
            if (students[i].equals(inputName)) {
                System.out.println("Position of the student " + inputName + " is: " +i);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Not found the student " + inputName + " in list");
        }
    }
}
