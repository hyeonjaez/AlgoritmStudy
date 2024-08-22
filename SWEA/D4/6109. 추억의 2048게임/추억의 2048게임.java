import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static final int[] dx = {-1, 0, 1, 0};
    public static final int[] dy = {0, 1, 0, -1};
    static int n;
    static int direction;
    static int[][] map;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= testCount; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            switch (st.nextToken()) {
                case "up":
                    direction = 0;
                    break;
                case "down":
                    direction = 2;
                    break;
                case "left":
                    direction = 3;
                    break;
                case "right":
                    direction = 1;
                    break;
            }

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            startGame();


            sb.append("#").append(tc).append("\n");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void startGame() {
        List<Deque<Position>> gameList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            gameList.add(new ArrayDeque<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nextX = i;
                int nextY = j;
                if (map[i][j] == 0) {
                    continue;
                }

                while (true) {
                    nextX += dx[direction];
                    nextY += dy[direction];

                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                        nextX -= dx[direction];
                        nextY -= dy[direction];

                        if (direction == 0) {
                            gameList.get(j).add(new Position(nextX, nextY, map[i][j]));
                        } else if (direction == 1) {
                            gameList.get(i).push(new Position(nextX, nextY, map[i][j]));
                        } else if (direction == 2) {
                            gameList.get(j).push(new Position(nextX, nextY, map[i][j]));
                        } else if (direction == 3) {
                            gameList.get(i).add(new Position(nextX, nextY, map[i][j]));
                        }
                        map[i][j] = 0;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            while (!gameList.get(i).isEmpty()) {
                Position nowPosition = gameList.get(i).poll();

                int nextX = nowPosition.row + dx[(direction + 2) % 4] * count;
                int nextY = nowPosition.col + dy[(direction + 2) % 4] * count;

                if (map[nextX][nextY] == 0) {
                    map[nextX][nextY] = nowPosition.value;
                } else if (map[nextX][nextY] == nowPosition.value) {
                    map[nextX][nextY] += nowPosition.value;
                    count++;
                } else {
                    count++;
                    nextX = nowPosition.row + dx[(direction + 2) % 4] * count;
                    nextY = nowPosition.col + dy[(direction + 2) % 4] * count;
                    map[nextX][nextY] = nowPosition.value;
                }
            }
        }
    }
}

class Position {
    int row;
    int col;
    int value;

    public Position(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}