public class Main {
    public static void main(String[] args) {
        double[] result = QuadraticEquations.solve(1,2,1);
        if (result == null){
            System.out.println("Phuong trinh vo nghiem");
        } else {
            for (int i = 0; i < result.length ; i++) {
                System.out.println("Phuong trinh co nghiem: "+result[i]);
            }
        }
    }
}
