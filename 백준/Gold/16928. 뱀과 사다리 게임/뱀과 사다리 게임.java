import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dice = {0, 1, 2, 3, 4, 5, 6};
    static int[] map;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[101];
        visited = new boolean[101];

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start] = end;
        }
        bf();

        System.out.println(min);


    }

    public static void bf() {
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            if (now.index == 100) {
                min = Integer.min(now.count, min);
                continue;
            }

            visited[now.index] = true;

            for (int i = 1; i <= 6; i++) {
                int nextIndex = now.index + dice[i];
                if (nextIndex > 100 || visited[nextIndex]) {
                    continue;
                }

                if (map[nextIndex] > 0) {
                    if (!visited[map[nextIndex]]) {
                        queue.add(new Edge(map[nextIndex], now.count + 1));
                    }
                } else {
                    queue.add(new Edge(nextIndex, now.count + 1));
                }
            }
        }
    }

}

class Edge {
    int index;
    int count;

    Edge(int index, int count) {
        this.index = index;
        this.count = count;
    }

}