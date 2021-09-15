package _11_stack_queue.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseByStack {
    public static void main(String[] args) {
        //arraylist
        ArrayList<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        System.out.println("Before reverse: ");
        System.out.println(listInteger);

        Stack<Integer> stack = new Stack<>();
        while (!listInteger.isEmpty()) {
            stack.push(listInteger.remove(0));
        }
        while (!stack.empty()) {
            listInteger.add(stack.pop());
        }
        System.out.println("After reverse: ");
        System.out.println(listInteger);

        //linkedlist
        LinkedList<Integer> linkedListInteger = new LinkedList<>();
        linkedListInteger.add(1);
        linkedListInteger.add(2);
        linkedListInteger.add(3);
        linkedListInteger.add(4);
        linkedListInteger.add(5);
        System.out.println("Before reverse: ");
        System.out.println(linkedListInteger);

        while (!linkedListInteger.isEmpty()) {
            stack.push(linkedListInteger.removeFirst());
        }

        while (!stack.isEmpty()) {
            linkedListInteger.add(stack.pop());
        }

        System.out.println("After reverse: ");
        System.out.println(linkedListInteger);

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
