import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int result;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for (int i = 1; i <= testCount; i++) {
                result = 0;
                N = Integer.parseInt(br.readLine());
                map = new int[N][N];
                visited = new boolean[N][N];

                for (int x = 0; x < N; x++) {
                    st = new StringTokenizer(br.readLine());
                    for (int y = 0; y < N; y++) {
                        map[x][y] = Integer.parseInt(st.nextToken());
                    }
                }

                st = new StringTokenizer(br.readLine());
                startX = Integer.parseInt(st.nextToken());
                startY = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                endX = Integer.parseInt(st.nextToken());
                endY = Integer.parseInt(st.nextToken());

                if (startX == endX && startY == endY) {
                    System.out.println("#" + i + " " + 0);
                    continue;
                }

                System.out.println("#" + i + " " + (bfs() ? result : -1));


            }
        }
    }

    public static boolean bfs() {
        Queue<Player> q = new LinkedList<>();
        q.add(new Player(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Player player = q.poll();

            for (int i = 0; i < 4; i++) {
                int positionX = player.row + dx[i];
                int positionY = player.col + dy[i];

                if (positionX < 0 || positionX >= N || positionY < 0 || positionY >= N) {
                    continue;
                }

                if (positionX == endX && positionY == endY) {
                    result = player.count + 1;
                    return true;
                }

                if (map[positionX][positionY] == 1 || visited[positionX][positionY]) {
                    continue;
                }

                if (map[positionX][positionY] == 2) {
                    if (player.count % 3 == 2) {
                        visited[positionX][positionY] = true;
                        q.add(new Player(positionX, positionY, player.count + 1));
                    } else {
                        visited[player.row][player.col] = true;
                        q.add(new Player(player.row, player.col, player.count + 1));
                    }
                } else {
                    visited[positionX][positionY] = true;
                    q.add(new Player(positionX, positionY, player.count + 1));
                }
            }
        }
        return false;
    }
}

class Player {
    int row;
    int col;
    int count;

    public Player(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}