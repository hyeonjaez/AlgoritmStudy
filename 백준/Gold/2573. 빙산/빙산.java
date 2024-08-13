import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		while (true) {
			int nowCount = check();
			if (nowCount >= 2) {
				break;
			} else if (nowCount == 0) {
				year = 0;
				break;
			}
			year++;
			passOneYear();
		}
		System.out.println(year);
	}

	public static void passOneYear() {
		Queue<Ice> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] > 0) {
					queue.add(new Ice(i, j));
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			Ice poll = queue.poll();
			int seaCount = 0;
			for (int i = 0; i < 4; i++) {
				int aroundX = poll.x + dx[i];
				int aroundY = poll.y + dy[i];

				if (aroundX >= 0 && aroundX < n && aroundY >= 0 && aroundY < m) {
					if (!visited[aroundX][aroundY] && map[aroundX][aroundY] == 0) {
						seaCount++;
					}
				}
			}

			if (map[poll.x][poll.y] - seaCount < 0) {
				map[poll.x][poll.y] = 0;
			} else {
				map[poll.x][poll.y] -= seaCount;
			}
		}
	}

	public static int check() {
		int count = 0;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					dfs(i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int x, int y, boolean[][] visited) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int moveX = x + dx[i];
			int moveY = y + dy[i];

			if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < m) {
				if (map[moveX][moveY] > 0 && !visited[moveX][moveY]) {
					dfs(moveX, moveY, visited);
				}
			}
		}

	}
}

class Ice {
	int x;
	int y;

	public Ice(int x, int y) {
		this.x = x;
		this.y = y;
	}
}