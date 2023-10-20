import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N;
    static long[][] dp; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new long[N][N]; 

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        long ways = dfs(0, 0);
        System.out.println(ways);
    }

    public static long dfs(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            return 1; 
        }

        if (dp[x][y] != -1) {
            return dp[x][y]; 
        }

        dp[x][y] = 0; 

        int jump = map[x][y];

        if (jump > 0) {
           
            if (x + jump < N) {
                dp[x][y] += dfs(x + jump, y);
            }
            
            if (y + jump < N) {
                dp[x][y] += dfs(x, y + jump);
            }
        }

        return dp[x][y];
    }
}
