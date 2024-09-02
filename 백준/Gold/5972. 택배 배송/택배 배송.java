import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static List<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new List[n + 1];
        array = new int[n + 1];
        Arrays.fill(array, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        search(1);

        System.out.println(array[n]);
    }

    public static void search(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        array[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nowIndex = node.index;
            int nowDistance = node.weight;

            if (array[nowIndex] < nowDistance) {
                continue;
            }

            for (Node nextNode : graph[nowIndex]) {
                int cost = array[nowIndex] + nextNode.weight;
                if (array[nextNode.index] > cost) {
                    array[nextNode.index] = cost;
                    queue.add(new Node(nextNode.index, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
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