import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[][] size;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int count = 1;
		while (Integer.parseInt(str) != 0) {
			n = Integer.parseInt(str);
			map = new int[n][n];
			size = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					size[i][j] = Integer.MAX_VALUE;
				}
			}

			bfs(0, 0, map[0][0]);
			sb.append("Problem").append(" ").append(count).append(":").append(" ").append(size[n - 1][n - 1])
					.append("\n");
			count++;
			str = br.readLine();
		}
		System.out.println(sb);

	}

	public static void bfs(int x, int y, int weight) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		visited[x][y] = true;
		size[x][y] = weight;
		queue.add(new Node(x, y, weight));

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];

				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
					if (!visited[nextX][nextY]) {
						int cost = now.weight + map[nextX][nextY];
						if (size[nextX][nextY] > cost) {
							size[nextX][nextY] = cost;
							visited[nextX][nextY] = true;
							queue.add(new Node(nextX, nextY, size[nextX][nextY]));
						}
					}
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int x;
	int y;
	int weight;

	Node(int x, int y, int weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}