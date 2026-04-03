import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        min = Integer.MAX_VALUE;

        bfs(n);

        System.out.println(min);
    }

    public static void bfs(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.index] = true;
            if (now.index == k) {
                min = Math.min(now.value, min);
                continue;
            }

            if (now.index - 1 >= 0) {
                if (!visited[now.index - 1]) {
                    queue.add(new Node(now.index - 1, now.value + 1));
                }
            }

            if (now.index + 1 < 100001) {
                if (!visited[now.index + 1]) {
                    queue.add(new Node(now.index + 1, now.value + 1));
                }
            }

            if (now.index * 2 < 100001) {
                if (!visited[now.index * 2]) {
                    queue.add(new Node(now.index * 2, now.value));
                }
            }
        }
    }

}

class Node {
    int index;
    int value;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}