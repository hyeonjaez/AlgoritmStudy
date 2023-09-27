package org.example.same_number_hate;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        Arrays.stream(solution(arr1)).forEach(System.out::println);
        System.out.println("====================================");
        Arrays.stream(solution(arr2)).forEach(System.out::println);
    }

    public static int[] solution(int[] array) {
        Stack<Integer> stack = new Stack<>();

        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (stack.peek() != array[i]) {
                stack.push(array[i]);
            }
        }

        return stack.stream().mapToInt(value -> value).toArray();
    }
}
