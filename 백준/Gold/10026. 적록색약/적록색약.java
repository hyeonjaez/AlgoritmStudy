import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static char[][] map;
    static char[][] diMap;
    static boolean[][] visited;
    static final int[] DX = {0, 0, -1, 1};
    static final int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        diMap = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'R' || map[i][j] == 'G') {
                    diMap[i][j] = 'R';
                } else {
                    diMap[i][j] = map[i][j];
                }
            }
        }

        int countA = 0;
        int countB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    countA++;
                    dfs(i, j, map[i][j]);
                }
            }
        }
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    countB++;
                    dfs2(i, j, diMap[i][j]);
                }
            }
        }

        System.out.println(countA + " " + countB);
        

    }

    public static void dfs(int i, int j, char target) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nextX = i + DX[k];
            int nextY = j + DY[k];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                if (map[nextX][nextY] == target) {
                    dfs(nextX, nextY, target);
                }
            }
        }

    }

    public static void dfs2(int i, int j, char target) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nextX = i + DX[k];
            int nextY = j + DY[k];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                if (diMap[nextX][nextY] == target) {
                    dfs2(nextX, nextY, target);
                }
            }
        }

    }
}