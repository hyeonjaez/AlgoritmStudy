import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int target;

    static int INF = Integer.MAX_VALUE;
    static List<Edge>[] map;
    static List<Edge>[] reverseMap;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        map = new List[n + 1];
        reverseMap = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
            reverseMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Edge(b, c));
            reverseMap[b].add(new Edge(a, c));
        }

        int[] go = da(map, target);
        int[] back = da(reverseMap, target);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, go[i] + back[i]);
        }

        System.out.println(max);
    }

    static int[] da(List<Edge>[] graph, int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        queue.add(new Edge(start, 0));

        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            int now = poll.index;
            int cost = poll.value;

            if (distance[now] < cost) {
                continue;
            }

            for (Edge edge : graph[now]) {
                if (distance[now] + edge.value < distance[edge.index]) {
                    distance[edge.index] = distance[now] + edge.value;
                    queue.add(new Edge(edge.index, distance[edge.index]));
                }
            }
        }

        return distance;
    }
}

class Edge implements Comparable<Edge> {
    int index;
    int value;

    Edge(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}