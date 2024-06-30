import java.io.*;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer;
            int testCount = Integer.parseInt(bufferedReader.readLine());

            for (int test = 1; test <= testCount; test++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                int N = Integer.parseInt(stringTokenizer.nextToken());
                int M = Integer.parseInt(stringTokenizer.nextToken());

                int[] A = new int[N];
                int[] B = new int[M];

                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int n = 0; n < N; n++) {
                    A[n] = Integer.parseInt(stringTokenizer.nextToken());
                }

                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int m = 0; m < M; m++) {
                    B[m] = Integer.parseInt(stringTokenizer.nextToken());
                }

                int sum = 0;
                int maxSum = 0;

                if (N < M) {
                    int different = M - N;

                    for (int i = 0; i <= different; i++) {
                        for (int j = 0; j < N; j++) {
                            sum += A[j] * B[j + i];
                        }
                        maxSum = Math.max(maxSum, sum);
                        sum = 0;
                    }
                } else if (N > M) {
                    int different = N - M;
                    for (int i = 0; i <= different; i++) {
                        for (int j = 0; j < M; j++) {
                            sum += A[j + i] * B[j];
                        }
                        maxSum = Math.max(maxSum, sum);
                        sum = 0;
                    }
                } else {
                    for (int i = 0; i < N; i++) {
                        maxSum += A[i] * B[i];
                    }
                }

                bufferedWriter.write("#" + test + " " + maxSum + "\n");
            }
            bufferedWriter.flush();

        }
    }
}