package org.example.leastcommonmultiple;

public class LeastCommonMultiple {

    public static void main(String[] args) {
        System.out.println(solution(32, 35));
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
