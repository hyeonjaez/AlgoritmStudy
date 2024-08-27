import java.io.*;
import java.util.*;

public class Solution {

    static char[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; //상 -> 상좌 순으로 팔방탐색 
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int result;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            result = 0;
            N = Integer.parseInt(br.readLine().trim());
            map = new char[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                String line = st.nextToken();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (bomb(i, j) == 0 && map[i][j] != '*' && !visited[i][j]) {
                        result += 1;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') {
                        map[i][j] = (char) (bomb(i, j) + '0');
                        visited[i][j] = true;
                        result += 1;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }


    public static int bomb(int r, int c) {
        int cnt = 0;
        for (int d = 0; d < 8; d++) {
            int nextX = r + dx[d];
            int nextY = c + dy[d];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (map[nextX][nextY] == '*') {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }


    public static void bfs(int r, int c) {
        ArrayDeque<char[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.offer(new char[]{(char) (r + '0'), (char) (c + '0')});

        while (!queue.isEmpty()) {
            char[] oj = queue.poll();
            int i = oj[0] - '0';
            int j = oj[1] - '0';
            int cnt = bomb(i, j);
            map[i][j] = (char) (cnt + '0');

            if (cnt > 0) {
                continue;
            }

            for (int d = 0; d < 8; d++) {
                int nextX = i + dx[d];
                int nextY = j + dy[d];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY] && map[nextX][nextY] != '*') {
                    visited[nextX][nextY] = true;
                    queue.offer(new char[]{(char) (nextX + '0'), (char) (nextY + '0')});
                }
            }
        }
    }

}