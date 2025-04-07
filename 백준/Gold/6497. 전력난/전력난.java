import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 || m == 0) {
                break;
            }

            parents = new int[n];
            Edge[] array = new Edge[m];
            int total = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                array[i] = new Edge(x, y, count);
                total += count;
            }

            init();
            Arrays.sort(array);
            int result = 0;
            for (Edge edge : array) {
                if (union(edge.x, edge.y)) {
                    result += edge.count;
                }
            }

            System.out.println(total - result);
        }


    }

    public static void init() {
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public static int findRoot(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = findRoot(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[aRoot] = bRoot;
        return true;
    }


}

class Edge implements Comparable<Edge> {
    int x;
    int y;
    int count;

    public Edge(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int compareTo(Edge edge) {
        return this.count - edge.count;
    }
}