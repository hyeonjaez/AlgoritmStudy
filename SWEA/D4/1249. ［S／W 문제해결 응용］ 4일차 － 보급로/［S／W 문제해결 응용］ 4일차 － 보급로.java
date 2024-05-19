import java.util.PriorityQueue;
import java.util.Queue;
import java.io.*;

class Solution {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int min;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(br.readLine());

            for (int i = 0; i < testCount; i++) {
                N = Integer.parseInt(br.readLine());
                map = new int[N][N];
                visited = new boolean[N][N];
                min = Integer.MAX_VALUE;

                for (int j = 0; j < N; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < N; k++) {
                        map[j][k] = s.charAt(k) - '0';
                    }
                }
                bfs(0, 0);

                System.out.println("#" + (i + 1) + " " + min);
            }

        }

    }

    public static void bfs(int x, int y) {
        Queue<Position> queue = new PriorityQueue<>();
        queue.add(new Position(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Position poll = queue.poll();
            int pollX = poll.x;
            int pollY = poll.y;
            int pollTime = poll.time;

            if (pollX == N - 1 && pollY == N - 1) {
                min = min > pollTime ? pollTime : min;
            }

            for (int i = 0; i < 4; i++) {
                int ix = pollX + dx[i];
                int iy = pollY + dy[i];

                

                if (ix >= 0 && iy >= 0 && ix < N && iy < N) {
                    if (!visited[ix][iy]) {
                        int totalTime = pollTime + map[ix][iy];
                        queue.add(new Position(ix, iy, totalTime));
                        visited[ix][iy] = true;
                    }
                }
            }
        }

    }

    static class Position implements Comparable<Position> {
        int x;
        int y;
        int time;
    
        Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    
        @Override
        public int compareTo(Position o) {
            if (this.time < o.time) {
                return -1;
            } else if (this.time > o.time) {
                return 1;
            }
            return 0;
        }
    }
}