import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int B;
	static int minResult;
	static int[] array;
	static int limit;
	static int[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= testCount; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			array = new int[N];
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			minResult = Integer.MAX_VALUE;

			for (int i = 1; i <= N; i++) {
				selected = new int[i];
				limit = i;
				dfs(0, 0);
			}
			
			sb.append("#").append(tc).append(" ").append(minResult-B).append("\n");

		}
		
		System.out.println(sb);
	}

	public static void dfs(int start, int depth) {
		if (limit == depth) {
			int sum = 0;
			for (int data : selected) {
				sum += data;
			}

			if (sum >= B) {
				minResult = Math.min(sum, minResult);
			}

			return;
		}

		for (int i = start; i < N; i++) {
			selected[depth] = array[i];
			dfs(i + 1, depth + 1);
		}
	}

}