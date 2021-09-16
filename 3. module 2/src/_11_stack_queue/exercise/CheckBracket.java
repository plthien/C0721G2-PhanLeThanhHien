package _11_stack_queue.exercise;

import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        String str1 = "s * (s – a) * (s – b) * (s – c)";
        String str2 = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        String str3 = "s * (s – a) * (s – b * (s – c)";
        String str4 = "s * (s – a) * s – b) * (s – c)";
        String str5 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        System.out.println(checkBracket(str1));
        System.out.println(checkBracket(str2));
        System.out.println(checkBracket(str3));
        System.out.println(checkBracket(str4));
        System.out.println(checkBracket(str5));
    }

    public static boolean checkBracket(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (Character.toString(str.charAt(i)).equals("(")) {
                stack.push(str.charAt(i));
            }
            if (Character.toString(str.charAt(i)).equals(")")) {
                if (stack.size() == 0) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }
}
