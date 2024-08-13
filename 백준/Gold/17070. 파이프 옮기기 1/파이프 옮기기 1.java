import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] map;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		count = 0;
		moveWidth(0, 1);
		System.out.println(count);

	}

	public static void moveWidth(int x, int y) {
		if (x == n - 1 && y == n - 1) {
			count++;
			return;
		}

		if (y + 1 < n && map[x][y + 1] == 0) {
			moveWidth(x, y + 1);

			if (x + 1 < n && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
				moveDeGak(x + 1, y + 1);
			}

		}
	}

	public static void moveHeight(int x, int y) {
		if (x == n - 1 && y == n - 1) {
			count++;
			return;
		}

		if (x + 1 < n && map[x + 1][y] == 0) {
			moveHeight(x + 1, y);

			if (y + 1 < n && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
				moveDeGak(x + 1, y + 1);
			}
		}
	}

	public static void moveDeGak(int x, int y) {
		if (x == n - 1 && y == n - 1) {
			count++;
			return;
		}
		if (y + 1 < n && map[x][y + 1] == 0) {
			moveWidth(x, y + 1);
		}
		if (x + 1 < n && map[x + 1][y] == 0) {
			moveHeight(x + 1, y);
			if (y + 1 < n && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
				moveDeGak(x + 1, y + 1);
			}
		}
	}

}