import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static boolean[] visited;
    static int[] lenArray;
    static int maxLen;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }


        lenArray = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        visited= new boolean[n + 1];
        maxLen = Integer.MIN_VALUE;

        bfs();

        int minIndex = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i < n + 1; i++) {
            if (lenArray[i] == maxLen) {
                count++;

                minIndex = Math.min(minIndex, i);
            }
        }

        System.out.println(minIndex + " " + maxLen + " " + count);


    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            maxLen = Math.max(maxLen, now.len);
            lenArray[now.index] = now.len;

            for (int next : map[now.index]) {
                if (!visited[next]) {
                    queue.add(new Node(next, now.len + 1));
                    visited[next] = true;
                }
            }
        }
    }


}

class Node {
    int index;
    int len;

    public Node(int index, int len) {
        this.index = index;
        this.len = len;
    }
}