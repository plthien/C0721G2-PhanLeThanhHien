package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class ConvertUSDToVND {
    public static void main(String[] args) {
        final int RATE = 23000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter USD: ");
        float usd = sc.nextFloat();
        float vnd = usd * RATE;
        System.out.println("VND: "+vnd);
    }
}
