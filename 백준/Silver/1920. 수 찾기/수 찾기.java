import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        Arrays.sort(A);

        int M = scanner.nextInt();

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = scanner.nextInt();
            int start = 0;
            int end = A.length - 1;

            while (start <= end) {
                int midIndex = (start + end) / 2;
                int midNum = A[midIndex];

                if (midNum > target) {
                    end = midIndex - 1;
                } else if (midNum < target) {
                    start = midIndex + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}