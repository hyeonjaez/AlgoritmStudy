import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int max;
    static int maxArea;
    static int nowArea;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        map = new int[n][n];
        visited = new boolean[n][n];
        max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        maxArea = 0;

        for (int now = 0; now < max + 1; now++) {
            nowArea = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (map[i][j] > now) {
                            dfs(now, i, j);
                            nowArea++;
                        }
                    } else {
                        visited[i][j] = true;
                    }
                }
            }

            maxArea = Math.max(maxArea, nowArea);
        }

        System.out.println(maxArea);


    }

    public static void dfs(int now, int i, int j) {
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nextI = i + dx[k];
            int nextJ = j + dy[k];

            if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n) {
                if (!visited[nextI][nextJ]) {
                    if (map[nextI][nextJ] > now) {
                        dfs(now, nextI, nextJ);
                    }
                }
            }
        }

    }
}