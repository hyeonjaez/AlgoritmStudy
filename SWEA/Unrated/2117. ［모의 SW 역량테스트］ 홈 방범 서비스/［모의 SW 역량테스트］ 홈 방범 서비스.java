import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {

    static int N;
    static int M;
    static int[][] map;
    static int[] profit = new int[22];

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int maxHome;
    static int home;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCount = Integer.parseInt(br.readLine());

        for (int i = 1; i < 22; i++) profit[i] = i * i + (i - 1) * (i - 1);

        for (int t = 1; t < testCount + 1; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            maxHome = home = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) home++;
                }
            }

            for (int k = 1; k < 22; k++) {
                if (home * M - profit[k] < 0) {
                    break;
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        bfs(i, j, k);
                    }
                }
            }
            System.out.println("#" + t + " " + maxHome);
        }
    }

    static void bfs(int x, int y, int k) {
        Queue<Point> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int depth = 0;
        int count = 0;

        que.add(new Point(x, y));
        visited[x][y] = true;

        while (!que.isEmpty()) {
            int size = que.size();

            if (depth == k) {
                break;
            }

            for (int s = 0; s < size; s++) {
                Point now = que.poll();
                if (map[now.x][now.y] == 1) {
                    count++;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    que.add(new Point(nx, ny));
                }
            }
            depth++;
        }
        if (count * M - profit[k] >= 0) {
            maxHome = Math.max(count, maxHome);
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}