import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new List[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }


        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }
        dfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
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