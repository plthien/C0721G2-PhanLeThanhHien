package _11_stack_queue.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        String str = "Able was I ere I saw Elba";

        String[] strArray = str.split("");
        for (int i = 0; i < strArray.length ; i++) {
            if (!strArray[i].equals(" ")) {
                queue.add(strArray[i].toLowerCase());
                stack.push(strArray[i].toLowerCase());
            }
        }
        System.out.println(stack);
        System.out.println(queue);
        boolean flag = true;
        int temp = stack.size()/2;
        while (stack.size() >= temp) {
            if (!stack.pop().equals(queue.remove())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str+ " is not s Palindrome");
        }

    }
}
