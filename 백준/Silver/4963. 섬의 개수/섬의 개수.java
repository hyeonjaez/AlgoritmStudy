import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, 1, -1, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = "";
        StringBuilder sb = new StringBuilder();
        while (!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        if (!visited[i][j]) {
                            count++;
                            dfs(i, j);
                        }
                    }

                }
            }

            System.out.println(count);


        }

    }

    public static void dfs(int x, int y) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                if (!visited[nextX][nextY]) {
                    if (map[nextX][nextY] == 1) {
                        dfs(nextX, nextY);
                    }
                }
            }
        }
    }


}