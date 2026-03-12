import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Node>[] map;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());


        map = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        visited = new boolean[n + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            map[start].add(new Node(end, count));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance[start] = 0;
        da(start);

        System.out.println(distance[end]);
    }

    public static void da(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;

            for (Node next : map[now.end]) {
                if (distance[next.end] > distance[now.end] + next.count) {
                    distance[next.end] = distance[now.end] + next.count;

                    queue.add(new Node(next.end, distance[next.end]));
                }
            }
        }
    }


}

class Node implements Comparable<Node> {
    int end;
    int count;

    Node(int end, int count) {
        this.end = end;
        this.count = count;
    }

    public int compareTo(Node o) {
        return this.count - o.count;
    }
}