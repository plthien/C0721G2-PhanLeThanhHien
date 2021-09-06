package _03_array_method.practice;


import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter The value of Fahrenheit: ");
                    double fahrenheit = sc.nextDouble();
                    System.out.println("The value of Celsius is: " + fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.println("Enter The value of Celsius: ");
                    double celsius = sc.nextDouble();
                    System.out.println("The value of Celsius is: " + celsiusToFahrenheit(celsius));
                    break;
//              case 0:
//                    System.exit(0);
            }
        } while (choice != 0);

    }

    public static double celsiusToFahrenheit(double celsius) {
        return 9 * celsius / 5 + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return 5 * (fahrenheit - 32) / 9;
    }
}
