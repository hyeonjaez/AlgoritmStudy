import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[][] array;
    static long[][] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        dp = new long[n][n];

        StringTokenizer st;

        for(int i = 0 ; i <n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n; j ++){
                array[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        
        

        System.out.println(dfs(0,0));
    }

    static long dfs(int x, int y){
        if(x ==n-1 && y ==n-1){
            return 1;
        }

        if(dp[x][y] != -1){
            return dp[x][y];
        }

        dp[x][y] =0;
        int jump = array[x][y];

        if(jump > 0){
            if(x + jump < n){
                dp[x][y] += dfs(x +jump, y);
            }

            if(y + jump <n ){
                dp[x][y] += dfs(x, y+jump);
            }
        }

        return dp[x][y];
    }
}