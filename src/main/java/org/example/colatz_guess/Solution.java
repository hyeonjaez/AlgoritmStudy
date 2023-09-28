package org.example.colatz_guess;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        int count = 0;
        long number = num;
        while (number != 1) {
            if (count == 500) {
                return -1;
            }
            count += 1;
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
        }
        return count;
    }
}

