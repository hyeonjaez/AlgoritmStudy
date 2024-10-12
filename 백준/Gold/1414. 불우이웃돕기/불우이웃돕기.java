import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Edge> edgeList;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        edgeList = new PriorityQueue<>();
        init();
        int total = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                if ('a' <= c && c <= 'z') {
                    total += c - 96;
                    edgeList.add(new Edge(i + 1, j + 1, c - 96));
                } else if ('A' <= c && c <= 'Z') {
                    total += c - 38;
                    edgeList.add(new Edge(i + 1, j + 1, c - 38));
                }
            }
        }
        int unionCount = 1;
        int result = 0;
        while (!edgeList.isEmpty()) {
            Edge edge = edgeList.poll();
            if (union(edge.start, edge.end)) {
                result += edge.power;
                unionCount++;
            }
        }


        if (unionCount == n) {
            System.out.println(total - result);
            return;
        }
        System.out.println(-1);


    }

    public static void init() {
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static int find(int target) {
        if (target == parent[target]) {
            return target;
        }
        return parent[target] = find(parent[target]);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        parent[rootA] = rootB;
        return true;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int power;

    public Edge(int start, int end, int power) {
        this.start = start;
        this.end = end;
        this.power = power;
    }

    @Override
    public int compareTo(Edge o) {
        return this.power - o.power;
    }
}