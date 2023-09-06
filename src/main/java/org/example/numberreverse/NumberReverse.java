package org.example.numberreverse;

public class NumberReverse {

    public static void main(String[] args) {
        //System.out.println(solution(456, 789));

        //System.out.println((solution2(456, 789)));

        System.out.println(solution3(456, 789));

        System.out.println(reverseNumberRecursive(456, 0));

        for (int i = 0; i < TESTCASES.length; i++) {
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2]));
        }

        System.out.println("정답률 = " + (int) (correctCount / TESTCASES.length * 100) + "%");
    }


    public static int solution(int a, int b) {

        return reverseNumber(reverseNumber(a) + reverseNumber(b));
    }

    public static int solution2(int a, int b) {
        return reverseNumber2(reverseNumber2(a) + reverseNumber2(b));
    }

    public static int solution3(int a, int b) {
        return reverseNumberRecursive((reverseNumberRecursive(a, 0) + reverseNumberRecursive(b, 0)), 0);
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

    public static int reverseNumberRecursive(int number, int result) {

        if (number == 0) {
            return result;
        } else {
            result = result * 10 + number % 10;
            return reverseNumberRecursive(number / 10, result);
        }
    }

    private static double correctCount = 0;

    private static final String[][] TESTCASES = new String[][] {
            {"123", "123", "246"},
            {"1000", "1", "2"},
            {"456", "789", "1461"},
            {"5", "5", "1"},
            {"11112", "54321", "65433"},
            {"3829", "1300", "4139"}
    };

    private static boolean test(String input, String input2, String answer) {
        int first = Integer.parseInt(input);
        int second = Integer.parseInt(input2);

        boolean res = String.valueOf(solution3(first, second)).equals(answer);
        if (res) {
            correctCount++;
        }
        return res;
    }

}
