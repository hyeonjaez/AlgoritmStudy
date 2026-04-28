import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Edge[] edges = new Edge[m];

        parents = new int[n + 1];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges);


        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int answer = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);

                answer += edge.value;
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }

        System.out.println(answer);

    }

    public static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            parents[findA] = findB;
        }
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return parents[a];
        }

        return parents[a] = find(parents[a]);
    }


}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int value;

    Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}
