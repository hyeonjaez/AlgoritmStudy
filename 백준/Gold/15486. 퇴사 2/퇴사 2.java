import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n + 2];

        for (int i = 1; i <= n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            int end = i + t[i];

            if (end <= n + 1) {
                dp[end] = Math.max(dp[end], dp[i] + p[i]);
            }
        }

        System.out.println(dp[n + 1]);

    }


}