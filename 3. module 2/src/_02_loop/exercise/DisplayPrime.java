package _02_loop.exercise;

public class DisplayPrime {
    public static void main(String[] args) {
        int count =0;
        for (int n =2; count < 20; n++) {
            boolean flag = true;
            for (int i =2 ; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(n + "\t");
                count++;
            }
        }
    }
}
