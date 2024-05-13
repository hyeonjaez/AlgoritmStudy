import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] sketchBook;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sketchBook = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    sketchBook[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[N][M];
            count = 0;
            int maxArea = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && sketchBook[i][j] == 1) {
                        maxArea = Math.max(maxArea, findArea(i, j, N, M));
                        count++;
                    }

                }
            }

            System.out.println(count);
            System.out.println(maxArea);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int findArea(int x, int y, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        int size = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];

            for (int i = 0; i < 4; i++) {
                int ix = pollX + dx[i];
                int iy = pollY + dy[i];
                if (ix >= N || iy >= M || ix < 0 || iy < 0) {
                    continue;
                }
                if (visited[ix][iy]) {
                    continue;
                }

                if (sketchBook[ix][iy] == 1) {
                    size++;
                    visited[ix][iy] = true;
                    queue.add(new int[] {ix, iy});
                }
            }
        }
        return size;
    }
}
