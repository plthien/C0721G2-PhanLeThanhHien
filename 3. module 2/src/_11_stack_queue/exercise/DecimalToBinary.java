package _11_stack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal: ");
        decimal = sc.nextInt();
        System.out.print("Binary: ");
        if (decimal >= 0) {
            displayBinary(convertDecimalToBinary(decimal));
        } else {
            decimal = decimal * (-1);
            displayBinary(convertNegativeBinary(convertDecimalToBinary(decimal)));
        }
    }

    public static Stack<Integer> convertDecimalToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();
        int temp = decimal;
        do {
            stack.push(temp % 2);
            temp = temp / 2;
        } while (temp != 0);

        if (decimal <= 127) {
            while (stack.size() < 8) {
                stack.push(0);
            }
        } else if (decimal <= 32767) {
            while (stack.size() < 16) {
                stack.push(0);
            }
        } else {
            while (stack.size() < 32) {
                stack.push(0);
            }
        }

        return stack;
    }

    public static void displayBinary(Stack<Integer> stack) {
        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }

    public static Stack<Integer> convertNegativeBinary(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (stack.size() > 0) {
            if (stack.pop() == 1) {
                tempStack.push(0);
            } else {
                tempStack.push(1);
            }
        }
        if (tempStack.pop() == 0) {
            tempStack.push(1);
        } else {
            int count = 1;
            while (tempStack.peek() == 1) {
                tempStack.pop();
                count++;
            }
            tempStack.pop();
            tempStack.push(1);
            while (count > 0) {
                tempStack.push(0);
                count--;
            }
        }

        while (tempStack.size() > 0) {
            stack.push(tempStack.pop());
        }

        return stack;

    }

}
