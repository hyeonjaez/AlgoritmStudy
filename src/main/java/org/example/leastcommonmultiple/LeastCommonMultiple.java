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
            {1, 1, 1},
            {98, 49, 98},
            {2, 81, 162},
            {3, 7, 21},
            {19, 87, 1653},
            {1, 40, 40}
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
