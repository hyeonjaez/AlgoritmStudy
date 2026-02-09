import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static int n;
    static int m;

    static int[][] map;

    static int[] dice = new int[7];
    static int nowX;
    static int nowY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nowY = Integer.parseInt(st.nextToken());
        nowX = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        int commandCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < commandCount; i++) {
            move(Integer.parseInt(st.nextToken()));
        }

    }

    public static void move(int d) {
        int nx = nowX + dx[d];
        int ny = nowY + dy[d];

        if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1) {
            return;
        }

        roll(d, nx, ny);
        nowX = nx;
        nowY = ny;
    }

    public static void roll(int d, int x, int y) {
        int temp = dice[3];

        switch (d) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = temp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;
        }

        if (map[y][x] == 0) {
            map[y][x] = dice[6];
        } else {
            dice[6] = map[y][x];
            map[y][x] = 0;
        }
        System.out.println(dice[3]);
    }
}