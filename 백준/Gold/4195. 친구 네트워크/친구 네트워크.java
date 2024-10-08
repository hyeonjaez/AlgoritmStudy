import java.util.*;
import java.io.*;

public class Main {
	static int[] parents;
	static int[] levels;
	static Map<String, Integer> map;
	static int index;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCount = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < testCount; tc++) {
			index = 0;
			int count = Integer.parseInt(br.readLine());
			parents = new int[count * 2];
			levels = new int[count * 2];
			map = new HashMap<>();
			for (int i = 0; i < count * 2; i++) {
				parents[i] = i;
				levels[i] = 1;
			}
			for (int i = 0; i < count; i++) {
				st = new StringTokenizer(br.readLine());

				String a = st.nextToken();
				String b = st.nextToken();

				if (!map.containsKey(a)) {
					map.put(a, index++);
				}
				if (!map.containsKey(b)) {
					map.put(b, index++);
				}

				int result = union(map.get(a), map.get(b));
				sb.append(result + "\n");
			}

		}
		System.out.println(sb.toString());
	}

	public static int find(int target) {
		if (parents[target] == target) {
			return target;
		}

		return parents[target] = find(parents[target]);
	}

	public static int union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);

		if (aParent != bParent) {
			parents[bParent] = aParent;
			levels[aParent] += levels[bParent];
			levels[bParent] = 1;
		}

		return levels[aParent];
	}

}