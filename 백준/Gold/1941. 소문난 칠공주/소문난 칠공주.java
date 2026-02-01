import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] board = new char[5][5];
    static int[] pick = new int[7];
    static boolean[] chosen = new boolean[25];
    static int answer = 0;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        comb(0, 0, 0);
        System.out.println(answer);


    }

    static void comb(int depth, int start, int sCount) {
        if (sCount + (7 - depth) < 4) {
            return;
        }

        if (depth == 7) {
            if (sCount >= 4 && isConnected()) {
                answer++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            pick[depth] = i;
            chosen[i] = true;

            int r = i / 5;
            int c = i % 5;

            int nextS = sCount + (board[r][c] == 'S' ? 1 : 0);

            int yCount = (depth + 1) - nextS;
            if (yCount < 4) {
                comb(depth + 1, i + 1, nextS);
            }
            chosen[i] = false;
        }
    }

    static boolean isConnected() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[25];

        queue.add(pick[0]);
        visited[pick[0]] = true;

        int reached = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int x = now / 5;
            int y = now % 5;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) {
                    continue;
                }


                int next = nextX * 5 + nextY;

                if (!chosen[next] || visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.add(next);
                reached++;
            }
        }

        return reached == 7;
    }


}