import java.io.*;
import java.util.StringTokenizer;

class Solution {
    static int max;
    static int N;
    static int M;

    static int[][] map;

    static int[] dpx = {-1, 0, 1, 0};
    static int[] dpy = {0, 1, 0, -1};

    static int[] dxX = {-1, -1, 1, 1};
    static int[] dxY = {1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCount = Integer.parseInt(bufferedReader.readLine());

            for (int i = 1; i <= testCount; i++) {
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                map = new int[N][N];

                for (int j = 0; j < N; j++) {
                    st = new StringTokenizer(bufferedReader.readLine());
                    for (int k = 0; k < N; k++) {
                        map[j][k] = Integer.parseInt(st.nextToken());
                    }
                }
                max = 0;
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        int plus = count(dpx, dpy, j, k);
                        int x = count(dxX, dxY, j, k);

                        int countMax = Math.max(plus, x);

                        max = Math.max(countMax, max);

                    }
                }
                bufferedWriter.write("#" + i + " " + max);
                bufferedWriter.write("\n");
            }

            bufferedWriter.flush();


        }
    }

    private static int count(int[] dx, int[] dy, int x, int y) {
        int sum = map[x][y];

        for (int i = 1; i < M; i++) {
            for (int d = 0; d < 4; d++) {
                int dr = x + dx[d] * i;
                int dc = y + dy[d] * i;
                if (dr >= 0 && dr < N && dc >= 0 && dc < N) {
                    sum += map[dr][dc];
                }
            }
        }
        return sum;

    }
}