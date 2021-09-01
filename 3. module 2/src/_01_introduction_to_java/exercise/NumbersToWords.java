package _01_introduction_to_java.exercise;


import com.sun.javafx.scene.web.Debugger;

import java.util.Scanner;

public class NumbersToWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number that you need to read:");
        int number = sc.nextInt();
        if (number >= 0 && number < 10) {
            switch (number) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
        } else if (number >= 10 && number < 20) {
            int ones = number - 10;
            switch (ones) {
                case 0:
                    System.out.println("Ten");
                    break;
                case 1:
                    System.out.println("Eleven");
                    break;
                case 2:
                    System.out.println("Twelve");
                    break;
                case 3:
                    System.out.println("Thirteen");
                    break;
                case 4:
                    System.out.println("Fourteen");
                    break;
                case 5:
                    System.out.println("Fifteen");
                    break;
                case 6:
                    System.out.println("Sixteen");
                    break;
                case 7:
                    System.out.println("Seventeen");
                    break;
                case 8:
                    System.out.println("Eighteen");
                    break;
                case 9:
                    System.out.println("Nineteen");
                    break;
            }
        } else if (number >= 20 && number < 100) {
            int ones = number % 10;
            int tenOf = number / 10;
            String str = "";
            switch (tenOf) {
                case 2:
                    str = "Twenty ";
                    break;
                case 3:
                    str = "Thirty ";
                    break;
                case 4:
                    str = "Fourty ";
                    break;
                case 5:
                    str = "Fifty ";
                    break;
                case 6:
                    str = "Sixty ";
                    break;
                case 7:
                    str = "Seventy ";
                    break;
                case 8:
                    str = "Eighty ";
                    break;
                case 9:
                    str = "Ninety ";
                    break;
            }
            switch (ones) {
                case 1:
                    str += "One";
                    break;
                case 2:
                    str += "Two";
                    break;
                case 3:
                    str += "Three";
                    break;
                case 4:
                    str += "Four";
                    break;
                case 5:
                    str += "Five";
                    break;
                case 6:
                    str += "Six";
                    break;
                case 7:
                    str += "Seven";
                    break;
                case 8:
                    str += "Eight";
                    break;
                case 9:
                    str += "Nine";
                    break;
            }
            System.out.println(str);
        } else if (number >= 100 & number < 1000) {
            int hundredOf = number / 100;
            int temp = number % 100;
            int tenOf = temp / 10;
            int ones = temp % 10;
            String str = "";
            switch (hundredOf) {
                case 1:
                    str = "One hundred ";
                    break;
                case 2:
                    str = "Two hundred ";
                    break;
                case 3:
                    str = "Three hundred ";
                    break;
                case 4:
                    str = "Four hundred ";
                    break;
                case 5:
                    str = "Five hundred ";
                    break;
                case 6:
                    str = "Six hundred ";
                    break;
                case 7:
                    str = "Seven hundred ";
                    break;
                case 8:
                    str = "Eight hundred ";
                    break;
                case 9:
                    str = "Nine hundred ";
                    break;
            }
            if (temp >= 20) {
                switch (tenOf) {
                    case 2:
                        str += "and Twenty ";
                        break;
                    case 3:
                        str += "and Thirty ";
                        break;
                    case 4:
                        str += "and Fourty ";
                        break;
                    case 5:
                        str += "and Fifty ";
                        break;
                    case 6:
                        str += "and Sixty ";
                        break;
                    case 7:
                        str += "and Seventy ";
                        break;
                    case 8:
                        str += "and Eighty ";
                        break;
                    case 9:
                        str += "and Ninety ";
                        break;
                }
                switch (ones) {
                    case 1:
                        str += "One";
                        break;
                    case 2:
                        str += "Two";
                        break;
                    case 3:
                        str += "Three";
                        break;
                    case 4:
                        str += "Four";
                        break;
                    case 5:
                        str += "Five";
                        break;
                    case 6:
                        str += "Six";
                        break;
                    case 7:
                        str += "Seven";
                        break;
                    case 8:
                        str += "Eight";
                        break;
                    case 9:
                        str += "Nine";
                        break;
                }
            } else if (temp >= 10){
                switch (temp) {
                    case 10:
                        str+= "and Ten";
                        break;
                    case 11:
                        str+= "and Eleven";
                        break;
                    case 12:
                        str+= "and Twelve";
                        break;
                    case 13:
                        str+= "and Thirteen";
                        break;
                    case 14:
                        str += "and Fourteen";
                        break;
                    case 15:
                        str+= "and Fifteen";
                        break;
                    case 16:
                        str+= "and Sixteen";
                        break;
                    case 17:
                        str+= "and Seventeen";
                        break;
                    case 18:
                        str+= "and Eighteen";
                        break;
                    case 19:
                        str+= "and Nineteen";
                        break;
                }
            } else {
                switch (ones) {
                    case 1:
                        str += "and One";
                        break;
                    case 2:
                        str += "and Two";
                        break;
                    case 3:
                        str += "and Three";
                        break;
                    case 4:
                        str += "and Four";
                        break;
                    case 5:
                        str += "and Five";
                        break;
                    case 6:
                        str += "and Six";
                        break;
                    case 7:
                        str += "and Seven";
                        break;
                    case 8:
                        str += "and Eight";
                        break;
                    case 9:
                        str += "and Nine";
                        break;
                }
            }

            System.out.println(str);
        } else {
            System.out.println("Out of ability!");
        }
    }
}
