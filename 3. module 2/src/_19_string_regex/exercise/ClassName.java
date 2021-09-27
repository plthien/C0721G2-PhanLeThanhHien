package _19_string_regex.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Class name: ");
        String className = sc.nextLine();
        System.out.println(className + " is valid: " + validateClassName(className));

    }

    public static boolean validateClassName(String className) {
        String regex = "^[CAP]\\d{4}[GHIKLM]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();

    }
}
