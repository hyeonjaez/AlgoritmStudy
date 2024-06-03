import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int start;
    static int end;
    static int[][] map;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            map = new int[n + 1][n + 1];
            dist = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = map[y][x] = 1;
            }

            dfs(start);

            System.out.println(dist[end] == 0 ? -1 : dist[end]);

        }
    }

    public static void dfs(int start) {
        if (start == end) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (map[start][i] == 1 && dist[i] == 0) {
                dist[i] = dist[start] + 1;
                dfs(i);
            }
        }
    }
}