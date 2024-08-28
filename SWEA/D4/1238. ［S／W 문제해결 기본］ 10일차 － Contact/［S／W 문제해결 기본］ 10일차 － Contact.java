import java.io.*;
import java.util.*;

public class Solution {
	static List<Integer>[] array;
	static boolean[] selected;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCount = 10;
		StringTokenizer st;
		sb = new StringBuilder();

		for (int tc = 1; tc <= testCount; tc++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			array = new List[101];
			selected = new boolean[101];

			st = new StringTokenizer(br.readLine());

			for (int i = 1; i < 101; i++) {
				array[i] = new ArrayList<>();
			}

			for (int i = 0; i < count / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				array[from].add(to);
				selected[from] = true;
				selected[to] = true;
			}
			sb.append("#").append(tc).append(" ");

			bfs(start);
		}
		System.out.println(sb);
	}

	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		selected[x] = false;
		List<Integer> list = new ArrayList<>();
		int max = 0;
		while (!queue.isEmpty()) {
			max = 0;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int now = queue.poll();

				for (int data : array[now]) {
					if (selected[data]) {
						selected[data] = false;
						queue.add(data);
						max = Math.max(max, data);
					}
				}
			}
			list.add(max);
		}

		sb.append(list.get(list.size() - 2)).append("\n");


	}

}
