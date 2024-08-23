import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;

	static Character[][] map;
	static Queue<int[]> animal;
	static Queue<int[]> water;
	static int result;

	static final int[] dx = { 0, 0, -1, 1 };
	static final int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new Character[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		animal = new LinkedList<>();
		water = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'S') {
					animal.add(new int[] { i, j, 0 });
				} else if (map[i][j] == '*') {
					water.add(new int[] { i, j });
				}
			}
		}

		result = -1;

		bfs();

		if (result == -1) {
			System.out.println("KAKTUS");
			return;
		}
		System.out.println(result);

	}

	public static void bfs() {
		while (!animal.isEmpty()) {
			int size = water.size();
			for (int i = 0; i < size; i++) {
				int[] poll = water.poll();
				for (int j = 0; j < 4; j++) {
					int nextX = poll[0] + dx[j];
					int nextY = poll[1] + dy[j];

					if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
						if (map[nextX][nextY] == '.') {
							map[nextX][nextY] = '*';
							water.add(new int[] { nextX, nextY });
						}
					}

				}

			}

			int animalSize = animal.size();

			for (int i = 0; i < animalSize; i++) {
				int[] poll = animal.poll();

				for (int j = 0; j < 4; j++) {
					int nextX = poll[0] + dx[j];
					int nextY = poll[1] + dy[j];
					int time = poll[2];

					if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
						if (map[nextX][nextY] == 'D') {
							result = time + 1;
							return;
						} else if (map[nextX][nextY] == '.') {
							map[nextX][nextY] = 'S';

							animal.add(new int[] { nextX, nextY, time + 1 });
						}
					}
				}
			}
		}
	}
}