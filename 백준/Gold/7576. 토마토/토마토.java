import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        queue.add(new int[] {i, j});
                    }
                }
            }

            System.out.println(bfs());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];

            for (int i = 0; i < 4; i++) {
                int ix = pollX + dx[i];
                int iy = pollY + dy[i];

                if (ix >= 0 && iy >= 0 && ix < N && iy < M) {
                    if (map[ix][iy] == 0) {
                        map[ix][iy] = map[pollX][pollY] + 1;
                        queue.add(new int[] {ix, iy});
                    }
                }
            }
        }
        if (isZero()) {
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for (int[] x : map) {
            for (int data : x) {
                max = Math.max(max, data);
            }
        }
        return max - 1;
    }

    public static boolean isZero() {
        for (int[] x : map) {
            for (int data : x) {
                if (data == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}