package org.example.numberreverse;

public class NumberReverse {

    public static void main(String[] args) {
        System.out.println(solution(456, 789));
    }

    public static int solution(int a, int b) {

        return reverseNumber(reverseNumber(a) + reverseNumber(b));
    }

    public static int reverseNumber(int num) {
        StringBuilder sb = new StringBuilder();

        char[] number = Integer.toString(num).toCharArray();

        for (int i = number.length - 1; i >= 0; i--) {
            sb.append(number[i]);
        }

        return Integer.parseInt(sb.toString());
    }
}
