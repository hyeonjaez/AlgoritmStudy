import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int subin = Integer.parseInt(st.nextToken());
            int brother = Integer.parseInt(st.nextToken());

            System.out.println(bfs(subin, brother));


        }
    }

    public static int bfs(int start, int end) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(start, 0));
        boolean[] visited = new boolean[100001];


        int result = Integer.MAX_VALUE;

        while (!qu.isEmpty()) {
            Node now = qu.poll();

            visited[now.position] = true;

            if (now.position == end) {
                result = Math.min(result, now.time);
            }

            if (now.position * 2 < 100001 && !visited[now.position * 2]) {
                qu.add(new Node(now.position * 2, now.time));
            }

            if (now.position + 1 < 100001 && !visited[now.position + 1]) {
                qu.add(new Node(now.position + 1, now.time + 1));
            }

            if (now.position - 1 >= 0 && !visited[now.position - 1]) {
                qu.add(new Node(now.position - 1, now.time + 1));
            }
        }
        return result;
    }

}

class Node {
    int position;
    int time;

    Node(int position, int time) {
        this.position = position;
        this.time = time;
    }
}