import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int n;
    static int cityCount;
    static int[][] map;

    static int[] parent;
    static int[] route;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cityCount = Integer.parseInt(br.readLine());
        route = new int[cityCount + 1];
        map = new int[n + 1][n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cityCount; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int index = find(route[1]);

        for (int i = 2; i < route.length; i++) {
            if (index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void init() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public static int find(int target) {
        if (parent[target] == target) {
            return target;
        }

        return parent[target] = find(parent[target]);
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            parent[aRoot] = bRoot;
        }
    }
}

