package org.example.cola_problem;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20)); //기댓값 : 19
        System.out.println(solution(3, 1, 20)); //기댓값 : 9
        System.out.println(solution(3, 2, 20)); //기댓값 : 36
    }


    public static int solution(int a, int b, int n) {
        int count = 0;
        int remain = 0;

        while (n >= a) {
            count += (n / a) * b;
            remain = n % a;
            n = (n / a) * b + remain;
        }
        return count;
    }
}

