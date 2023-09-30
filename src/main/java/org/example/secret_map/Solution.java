package org.example.secret_map;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        Arrays.stream(solution(n, arr1, arr2)).forEach(System.out::println);

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = String.format("%" + n + "s", answer[i]);
            answer[i] = answer[i].replaceAll("0", " ").replaceAll("1", "#");
        }


        return answer;
    }


}



