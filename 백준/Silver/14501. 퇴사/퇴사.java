import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];
        int[] DP = new int[n + 2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = n; i > 0; i--) {
            int next = i + T[i];
    
            if (next > n + 1) {
                DP[i] = DP[i + 1];
            } else {
                DP[i] = Math.max(DP[i + 1], P[i] + DP[next]);
            }
        }
    
        System.out.println(DP[1]);
    }
}