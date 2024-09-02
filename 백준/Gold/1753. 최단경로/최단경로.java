import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v;
    static int e;
    static int[] nodeWeight;
    static List<Node>[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int start = Integer.parseInt(br.readLine());
        edges = new List[v + 1];
        nodeWeight = new int[v + 1];

        Arrays.fill(nodeWeight, Integer.MAX_VALUE);

        for (int i = 1; i <= v; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Node(b, c));
        }

        search(start);
        nodeWeight[start] = 0;
        for (int i = 1; i <= v; i++) {
            if (nodeWeight[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(nodeWeight[i]).append("\n");
        }
        System.out.println(sb);


    }

    public static void search(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        nodeWeight[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int distance = node.weight;
            int nowIndex = node.index;

            if (nodeWeight[nowIndex] < distance) {
                continue;
            }

            for (Node nextNode : edges[nowIndex]) {
                int nextDistance =nodeWeight[nowIndex] + nextNode.weight;
                if (nodeWeight[nextNode.index] > nextDistance) {
                    nodeWeight[nextNode.index] = nextDistance;
                    queue.add(new Node(nextNode.index, nextDistance));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}

