package controllers;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int n = 5;
        int i = 0;
        int j = 0;
        int[][] arr = new int[n][n];
        do {
            arr = draw(n,arr,i,j);
            System.out.println(Arrays.deepToString(arr));
            n--;
            i++;
            j++;
        }while (n > 0);


//        System.out.println(Arrays.deepToString(arr));
    }
    static int[][] draw(int n, int[][] arr, int i, int j) {
        for (; i < n; i++) {
            for (; j < n; j++) {
                if (i ==0) {
                    arr[i][j] = j+1;
                }
                if (j == n -1) {
                    arr[i][j] = i + n;
                }
                if (i == n-1 && j!=n-1) {
                    arr[i][j] = n + 2 * i - j;
                }
                if (j == 0 &&  i > 0 && i< n-1){
                    arr[i][j] = 4 * n -3 -i;
                }

            }
        }
        return arr;

    }

}
