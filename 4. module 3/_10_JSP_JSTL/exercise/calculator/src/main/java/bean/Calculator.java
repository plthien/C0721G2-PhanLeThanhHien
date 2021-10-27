package bean;

public class Calculator {


    public static double calculate(double a, double b, String flag){
        double result = 0;
        switch (flag){
            case "addition":
                result = a+b;
                break;
            case "subtraction":
                result = a-b;
                break;
            case "multiplication":
                result = a*b;
                break;
            default:
                if (b==0) throw new ArithmeticException("Can't divide by zero");
                else result = a / b;
        }
        return result;
    }
}
