import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int n;
    static List<Integer>[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            map = new ArrayList[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                map[i] = new ArrayList<>();
            }

            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a].add(b);
                map[b].add(a);
            }


            for (int i = 0; i < n; i++) {
                if (answer != 1) {
                    dfs(i, 1);
                }
            }

            System.out.println(answer);


        }
    }

    public static void dfs(int start, int depth) {
        if (depth == 5) {
            answer = 1;
            return;
        }

        visited[start] = true;

        for (int a : map[start]) {
            if (!visited[a]) {
                dfs(a, depth + 1);
            }
        }
        visited[start] = false;
    }


}
