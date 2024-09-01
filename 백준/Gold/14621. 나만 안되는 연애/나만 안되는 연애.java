import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static String[] array;
    static Edge[] edgeArray;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new String[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            array[i] = st.nextToken();
        }

        edgeArray = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edgeArray[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(edgeArray);

        init();

        int nodeCount = 1;
        int sum = 0;
        for (Edge edge : edgeArray) {
            if (union(edge.a, edge.b)) {
                nodeCount++;
                sum += edge.weight;
            }
        }

        if (nodeCount == n) {
            System.out.println(sum);
            return;
        }
        System.out.println(-1);


    }

    public static void init() {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        if (array[a].equals(array[b])) {
            return false;
        }

        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) {
            return false;
        }

        parents[aParent] = bParent;

        return true;
    }

}

class Edge implements Comparable<Edge> {
    int a;
    int b;
    int weight;

    public Edge(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}