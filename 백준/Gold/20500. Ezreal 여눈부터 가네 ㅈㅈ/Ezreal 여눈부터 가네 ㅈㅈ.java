
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		if (N == 1) {
			System.out.println(0);
		} else if (N <= 3) {
			System.out.println(1);
		} else {

			dp[2] = 1;
			dp[3] = 1;

			for (int i = 4; i <= N; i++) {
				for (int j = i - 1; j >= 1; j--) {
					dp[i] = (dp[i] + dp[j]) % 1_000_000_007;
				}

				if (i % 2 == 0)
					dp[i]++;
			}

			System.out.println(dp[N]);
		}
	}
}