package org.example.maxdivisor;

public class MaxDivisor {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (max < solution(arr[i], arr[j])) {
                    max = solution(arr[i], arr[j]);
                }
            }
        }
        System.out.println(max);
    }

    public static int solution(int num1, int num2) {
        int max = 0;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                max = i;
            }
        }

        return max;
    }
}
