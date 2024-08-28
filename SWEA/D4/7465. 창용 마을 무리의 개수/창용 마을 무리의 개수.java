import java.io.*;
import java.util.*;

public class Solution {

	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Set<Integer> set;

		for (int tc = 1; tc <= testCount; tc++) {
			set = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			init(n);

			for (int i = 0; i < count; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			for (int i = 1; i <= n; i++) {
				set.add(findParents(i));
			}

			sb.append(set.size()).append("\n");

		}
		System.out.println(sb);
	}

	public static void init(int n) {
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	public static void union(int a, int b) {
		int p = findParents(a);
		int q = findParents(b);
		parents[q] = p;
	}

	public static int findParents(int n) {
		if (parents[n] == n) {
			return n;
		}
		parents[n] = findParents(parents[n]);
		return parents[n];
	}

}
