import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        List<Node>[] map = new List[n + 1];
        boolean[] visited = new boolean[n + 1];

        int[] count = new int[n + 1];
        Arrays.fill(count, Integer.MAX_VALUE);


        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        count[start] = 0;


        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));


        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;

            for (Node next : map[now.end]) {
                if (count[next.end] > count[now.end] + next.count) {
                    count[next.end] = count[now.end] + next.count;

                    queue.add(new Node(next.end, count[next.end]));
                }
            }
        }

        System.out.println(count[end]);

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