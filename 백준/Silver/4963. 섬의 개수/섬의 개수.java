import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1, -1, 1, -1, 1};
    static int[] dy = {1, 0, -1, 0, 1, 1, -1, -1};
    static int count;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st;

            String str = "";
            StringBuilder sb = new StringBuilder();
            while (!(str = br.readLine()).equals("0 0")) {
                st = new StringTokenizer(str);

                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());

                map = new int[M][N];
                visited = new boolean[M][N];

                for (int i = 0; i < M; i++) {
                    st = new StringTokenizer(br.readLine());

                    for (int j = 0; j < N; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                int count = 0;

                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j] && map[i][j] == 1) {
                            count++;
                            dfs(i, j);
                        }
                    }
                }

                sb.append(count).append("\n");
            }
            System.out.println(sb);
        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int ix = dx[i] + x;
            int iy = dy[i] + y;

            if (ix >= 0 && ix < M && iy >= 0 && iy < N) {
                if (!visited[ix][iy] && map[ix][iy] == 1) {
                    dfs(ix, iy);
                }
            }
        }
    }
}