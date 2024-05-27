import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;

                        result.add(bfs(i, j, map, visited));
                    }
                }
            }

            System.out.println(count);


            result.sort(Integer::compareTo);

            for (int data : result) {
                System.out.println(data);
            }
        }

    }

    public static int bfs(int x, int y, int[][] map, boolean[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];
            for (int i = 0; i < 4; i++) {
                int ix = pollX + dx[i];
                int iy = pollY + dy[i];

                if (ix >= 0 && ix < N && iy >= 0 && iy < N) {
                    if (map[ix][iy] == 1 && !visited[ix][iy]) {
                        queue.add(new int[] {ix, iy});
                        visited[ix][iy] = true;
                        count++;
                    }
                }
            }
        }

        return count;

    }
}