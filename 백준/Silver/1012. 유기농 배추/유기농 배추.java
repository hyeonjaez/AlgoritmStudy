import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int count;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());

                int K = Integer.parseInt(st.nextToken());

                map = new int[N][M];
                visited = new boolean[N][M];
                count = 0;
                for (int j = 0; j < K; j++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    map[x][y] = 1;
                }

                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < M; y++) {
                        if (map[x][y] == 1 && !visited[x][y]) {
                            dfs(x, y);
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }

        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int ix = dx[i] + x;
            int iy = dy[i] + y;

            if (ix >= 0 && ix < N && iy >= 0 && iy < M) {
                if (!visited[ix][iy] && map[ix][iy] == 1) {
                    dfs(ix, iy);
                }
            }
        }
    }
}