package _03_array_method.practice;

public class FindMinValue {
    public static void main(String[] args) {
        int [] arr = {5,2,4,11,9,17,3};
        int index = findMinValue(arr);
        System.out.println("The smallest element in the array is " + arr[index]);

    }
    public static int findMinValue (int [] arr) {
        int index = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] < arr[index]) {
                index = i;
            }
        }
        return index;
    }
}
