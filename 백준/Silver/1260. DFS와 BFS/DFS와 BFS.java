import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static boolean[] visited;
    static List<Integer> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        map = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(map[i]);
        }


        visited = new boolean[n + 1];
        result = new ArrayList<>();
        dfs(v);
        StringBuilder sb = new StringBuilder();

        result.forEach(a -> sb.append(a).append(" "));

        sb.append("\n");

        visited = new boolean[n + 1];
        result = new ArrayList<>();
        bfs(v);

        result.forEach(a -> sb.append(a).append(" "));

        System.out.println(sb);


    }

    public static void dfs(int i) {
        if (visited[i]) return;

        visited[i] = true;
        result.add(i);

        for (int j : map[i]) {
            if (!visited[j]) {
                dfs(j);
            }
        }
    }

    public static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);
            for (int j : map[now]) {
                if (!visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }


}
