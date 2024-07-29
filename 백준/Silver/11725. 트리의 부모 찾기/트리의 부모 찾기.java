import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            map = new List[n + 1];
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                map[i] = new ArrayList<>();
            }

            result = new int[n + 1];
            StringTokenizer st;
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a].add(b);
                map[b].add(a);
            }

            dfs(1);

            for (int i = 2; i < n + 1; i++) {
                System.out.println(result[i]);
            }
        }
    }

    public static void dfs(int n) {
        if (visited[n]) {
            return;
        }
        visited[n] = true;

        for (int i : map[n]) {
            if (!visited[i]) {
                result[i] = n;
                dfs(i);
            }
        }
    }


}
