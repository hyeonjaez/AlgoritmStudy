import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Integer>[] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        StringTokenizer st;
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }

        dfs(1);
        int result = 0;
        for(int i = 2; i<=n; i++){
            if(visited[i]){
                result++;
            }
        }

        System.out.println(result);

    }

    public static void dfs(int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (int j : map[i]) {
            if (!visited[j]) {
                dfs(j);
            }
        }
    }


}