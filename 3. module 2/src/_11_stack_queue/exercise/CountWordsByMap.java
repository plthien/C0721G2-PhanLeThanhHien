package _11_stack_queue.exercise;

import java.util.Map;
import java.util.TreeMap;

public class CountWordsByMap {
    public static void main(String[] args) {
        String str = "My name is Hien. I am 26 years old. What is your name? I am Hung, i am 26 years old!";
        System.out.println(countWords(str));
    }

    public static Map countWords(String str) {
        TreeMap<String, Integer> countMap = new TreeMap<>();
        String[] arr = str.split("[ .,?!]");
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) {
                if (!countMap.containsKey(arr[i].toLowerCase())) {
                    countMap.put(arr[i].toLowerCase(), 1);
                } else {
                    countMap.computeIfPresent(arr[i].toLowerCase(), (k, v) -> v + 1);
                }
            }
        }
        return countMap;
    }
}
