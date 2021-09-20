package _13_searching_algorithm.optional;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,3,4,5,6,8,10,20,24,30,36,42,47,60,74,90};
        System.out.println(binarySearch(array,0,array.length-1,1));


    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, left, middle - 1, value);
        } else {
            return binarySearch(array, middle + 1, right, value);
        }

    }
}
