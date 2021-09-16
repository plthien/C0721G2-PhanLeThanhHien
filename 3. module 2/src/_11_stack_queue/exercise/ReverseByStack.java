package _11_stack_queue.exercise;

import java.util.Arrays;
import java.util.Stack;

public class ReverseByStack {
    public static void main(String[] args) {
        int [] integerArray = {1,2,3,4,5};

        System.out.println("Before reverse: ");
        System.out.println(Arrays.toString(integerArray));
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < integerArray.length ; i++) {
            stack.push(integerArray[i]);
        }

        for (int i = 0; i < integerArray.length ; i++) {
            integerArray[i] = stack.pop();
        }
        System.out.println("After reverse: ");
        System.out.println(Arrays.toString(integerArray));


        //reverse string
        Stack<String> wStack = new Stack<>();

        String str = " I am on             my home";
        System.out.println("Before reverse: " + str);
        String newStr = "";
        String[] arr = str.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) {
                wStack.push(arr[i]);
            }
        }

        while (!wStack.isEmpty()) {
            newStr += wStack.pop() + " ";
        }
        System.out.println("After reverse: " + newStr);


    }


}
