package org.example.watermelon_clap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i % 2 == 1 ? "수" : "박");
        }
        return stringBuilder.toString();
    }
}
