package controllers;

public class test {
    public static void main(String[] args) {
        String s = "abcdedddd";
        System.out.println(countDifferentCharacters(s));
    }
    static int countDifferentCharacters(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return s.length() - count;


    }
}
