
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static String[][] map;
    static boolean[][] visited;

    static int resultW;
    static int resultB;
    static int count;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map = new String[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().split("");
            }

            resultW = 0;
            resultB = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j]) {
                        count = 0;

                        dfs(i, j);
                        int result = count * count;
                        if (map[i][j].equals("W")) {
                            resultW += result;
                        } else if (map[i][j].equals("B")) {
                            resultB += result;
                        }
                    }
                }
            }

            System.out.println(resultW + " " + resultB);


        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public static void dfs(int start, int end) {
        visited[start][end] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int ax = start + dx[i];
            int ay = end + dy[i];

            if (ax >= 0 && ax < n && ay >= 0 && ay < m) {
                if (!visited[ax][ay] && map[ax][ay].equals(map[start][end])) {
                    dfs(ax, ay);
                }
            }
        }

    }


}