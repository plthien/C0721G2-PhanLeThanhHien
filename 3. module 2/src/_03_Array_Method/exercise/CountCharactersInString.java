package _03_Array_Method.exercise;

import java.util.Scanner;

public class CountCharactersInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "This is a String!";
        System.out.println(str);
        char ch;
        System.out.println("Enter a character: ");
        ch =  sc.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch){
                count++;
            }
        }
        System.out.println("The number of occurrences of " +"'"+ch+"'" + " in String is " +count);
    }
}
