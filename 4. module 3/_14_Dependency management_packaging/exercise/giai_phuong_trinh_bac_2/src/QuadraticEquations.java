import java.util.ArrayList;

public class QuadraticEquations {

    public static double[]  solve(double a, double b, double c){
        double[] result = null;

        double delta = b*b - 4*a*c;
        if (delta > 0){
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);
            result = new double[]{x1, x2};

        } else if (delta == 0){
            double x = -b/(2*a);
            result = new double[]{x};
        }
        return result;
    }


}
