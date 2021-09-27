package _19_string_regex.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.println(phoneNumber + " is valid: " + validatePhoneNumber(phoneNumber));

    }

    public static boolean validatePhoneNumber(String phoneNumber){
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return  matcher.matches();

    }
}
