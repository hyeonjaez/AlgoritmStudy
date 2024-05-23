import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<List<Integer>> map;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            int count = Integer.parseInt(br.readLine());
            visited = new boolean[N + 1];
            map = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                map.add(new ArrayList<>());
            }

            StringTokenizer st;
            result = 0;
            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map.get(x).add(y);
                map.get(y).add(x);
            }

            bfs(1);
            System.out.println(result - 1);
        }


    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (!visited[now]) {
                result++;
                visited[now] = true;

                for (int n : map.get(now)) {
                    if (!visited[n]) {
                        queue.add(n);
                    }
                }
            }
        }
    }


}