package _13_searching_algorithm.optional;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxLengthString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = sc.nextLine();
        findMaxLengthString(str);
    }

    public static void findMaxLengthString(String str) {
        LinkedList<Character> maxStr = new LinkedList<>();
        LinkedList<Character> tempStr = new LinkedList<>();


        for (int i = 0; i < str.length(); i++) {
            if (tempStr.size() > 0 && str.charAt(i) <= tempStr.getLast()) {
                tempStr.clear();
            }
            tempStr.add(str.charAt(i));
            if (maxStr.size() < tempStr.size()){
                maxStr.clear();
                maxStr.addAll(tempStr);
            }

        }

        for (Character ch : maxStr) {
            System.out.print(ch);
        }
    }
}
