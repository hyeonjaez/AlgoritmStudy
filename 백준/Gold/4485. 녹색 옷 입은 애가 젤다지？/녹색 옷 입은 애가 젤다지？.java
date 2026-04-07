import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = 0;
        while (true) {
            number++;
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                System.out.println(sb);
                return;
            }

            int[][] map = new int[n][n];
            int[][] distance = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = INF;
                }
            }

            int nowAnswer = da(map, distance);

            sb.append("Problem ").append(number).append(": ").append(nowAnswer).append("\n");
        }

    }


    public static int da(int[][] map, int[][] distance) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        queue.add(new Edge(0, 0, map[0][0]));

        distance[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if (now.x == n - 1 && now.y == n - 1) {
                distance[n - 1][n - 1] = Math.min(now.value, distance[n - 1][n - 1]);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (isMove(nextX, nextY)) {
                    if (distance[nextX][nextY] > now.value + map[nextX][nextY]) {
                        distance[nextX][nextY] = now.value + map[nextX][nextY];

                        queue.add(new Edge(nextX, nextY, distance[nextX][nextY]));
                    }
                }
            }
        }

        return distance[n - 1][n - 1];
    }

    public static boolean isMove(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}

class Edge implements Comparable<Edge> {
    int x;
    int y;
    int value;

    Edge(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}