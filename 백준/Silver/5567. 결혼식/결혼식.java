import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        int result = 0;

        dfs(0, 1);
        for (int i = 2; i < n + 1; i++) {
            if (visited[i]) {
                result++;
            }
        }

        System.out.println(result);


    }

    public static void dfs(int depth, int i) {
        if (depth >= 2) {
            return;
        }

        for (int j : map[i]) {
            visited[j] = true;
            dfs(depth + 1, j);
        }
    }


}