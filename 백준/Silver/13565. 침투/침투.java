

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int M;
    static int N;
    static boolean isPass;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        isPass = false;
        for (int i = 0; i < N; i++) {
            DFS(0, i);
        }


        if (isPass) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static void DFS(int n, int m) {
        if (map[n][m] == 1) {
            return;
        }
        if (map[n][m] == 3) {
            return;
        }
        map[n][m] = 3;

        if (n == M - 1) {
            isPass = true;
        }

        if (n == 0 && m == 0) {
            DFS(n, m + 1);
            DFS(n + 1, m);
        } else if (n == M - 1 && m == N - 1) {
            DFS(n, m - 1);
            DFS(n - 1, m);
        } else if (n == 0) {
            if (m == N - 1) {
                DFS(n, m - 1);
                DFS(n + 1, m);
            } else {
                DFS(n, m + 1);
                DFS(n, m - 1);
                DFS(n + 1, m);

            }
        } else if (m == 0) {
            if (n == M - 1) {
                DFS(n - 1, m);
                DFS(n, m + 1);
            } else {
                DFS(n + 1, m);
                DFS(n - 1, m);
                DFS(n, m + 1);
            }
        } else if (n == M - 1) {
            DFS(n - 1, m);
            DFS(n, m + 1);
            DFS(n, m - 1);
        } else if (m == N - 1) {
            DFS(n, m - 1);
            DFS(n + 1, m);
            DFS(n - 1, m);
        } else {
            DFS(n - 1, m);
            DFS(n + 1, m);
            DFS(n, m + 1);
            DFS(n, m - 1);
        }

    }
}
