import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static Edge[] edgeList;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edgeList = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(a, b, w);
        }
        int bigCost = 0;
        Arrays.sort(edgeList);
        init();
        int selectTotal = 0;
        for (Edge e : edgeList) {
            if (union(e.start, e.end)) {
                selectTotal += e.weight;
                bigCost = e.weight;
            }
        }

        System.out.println(selectTotal - bigCost);

    }

    public static void init() {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if (parents[a] == a) return a;

        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return false;
        parents[aRoot] = bRoot;

        return true;
    }

}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}