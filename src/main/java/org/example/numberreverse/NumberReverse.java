package org.example.numberreverse;

public class NumberReverse {

    public static void main(String[] args) {
        //System.out.println(solution(456, 789));

        //System.out.println((solution2(456, 789)));

        System.out.println(solution3(456, 789));

        System.out.println(reverseNumberRecursive(456));
    }

    public static int solution(int a, int b) {

        return reverseNumber(reverseNumber(a) + reverseNumber(b));
    }

    public static int solution2(int a, int b) {
        return reverseNumber2(reverseNumber2(a) + reverseNumber2(b));
    }

    public static String solution3(int a, int b) {
        return reverseNumberRecursive(
                Integer.parseInt(reverseNumberRecursive(a)) + Integer.parseInt(reverseNumberRecursive(b)));
    }

    public static int reverseNumber(int num) {
        StringBuilder sb = new StringBuilder();

        char[] number = Integer.toString(num).toCharArray();

        for (int i = number.length - 1; i >= 0; i--) {
            sb.append(number[i]);
        }

        return Integer.parseInt(sb.toString());
    }

    public static int reverseNumber2(int num) {
        int result = 0;

        while (num != 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        return result;
    }

    public static String reverseNumberRecursive(int number) {
        StringBuilder sb = new StringBuilder();

        while (number != 0) {

            sb.append(number % 10);
            number /= 10;
            reverseNumberRecursive(number);
        }

        return sb.toString();
    }
}
