package org.example.numberWhirlwind;

public class NumberWhirlWind {
    public static void main(String[] args) {
        int n = 4;
        int[][] numbers = solution(n);
        for (int[] number : numbers) {
            for (int num : number) {
                System.out.print(num);
            }
            System.out.println();
        }
    }

    public static int[][] solution(int number) {
        int n = number;
        int[][] answer = new int[n][n];

        int count = 1;
        int x = 0;
        int y = -1;
        int direction = 1;

        while (n > 0) {
            for (int i = 0; i < n; i++) {
                y += direction;
                answer[x][y] = count++;
            }
            n--;
            for (int i = 0; i < n; i++) {
                x += direction;
                answer[x][y] = count++;
            }
            direction *= -1;
        }
        return answer;
    }
}
