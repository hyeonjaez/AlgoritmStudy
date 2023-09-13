package org.example.leastcommonmultiple;

public class LeastCommonMultiple {

    private static double correct = 0;

    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println(
                    "Test Case" + (i + 1) + " = " + test(TEST_CASES[i][0], TEST_CASES[i][1], TEST_CASES[i][2]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }

    private static final int[][] TEST_CASES = new int[][] {
            {123, 12, 492},
            {2, 3, 6},
            {23, 14, 322},
            {4, 13, 52},
            {34, 2, 34}
    };

    private static boolean test(int start, int end, int result) {
        if (solution(start, end) == result) {
            correct++;
            return true;
        }

        return false;
    }

    public static int solution(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int gcd(int a, int b) {
        if (a < b) {
            int swap = a;
            a = b;
            b = swap;
        }
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

}
