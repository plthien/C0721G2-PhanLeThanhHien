package _13_searching_algorithm.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class StringSearching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = sc.nextLine();
        searchString(str);


    }

    public static void searchString(String str) {
        LinkedList<Character> maxStr = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) { // O(n)
            LinkedList<Character> tempStr = new LinkedList<>();
            tempStr.add(str.charAt(i));

            for (int j = i+1; j < str.length() ; j++) { //O(n-1)
                if (str.charAt(j) > tempStr.getLast()) {
                    tempStr.add(str.charAt(j));
                }
            }
            if (maxStr.size() < tempStr.size()){//O(1)
                maxStr.clear();
                maxStr.addAll(tempStr);
            } else {
                tempStr.clear();
            }

        }

        for (Character ch:maxStr) {//O(m) m<=n
            System.out.print(ch);
        }
    }
}
//O(n)*(O(n-1)+ O(1)) + O(m) = O(n)*O(n-1) + O(m) = O(n*(n-1))+O(m)=O(n^2 - n) + O(m)
// = O(n^2 + (-n)) + O(m) = O(n^2) +O(m) = O(n^2)