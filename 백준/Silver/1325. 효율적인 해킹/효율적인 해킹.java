import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> list;
    static boolean[] visited;
    static int count;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
        }

        for (int i = 1; i <= N; i++) {
            count = 0;
            visited = new boolean[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int a : list.get(now)) {
                    if (!visited[a]) {
                        visited[a] = true;
                        queue.add(a);
                        count++;
                    }
                }
            }
            map.put(i, count);


        }
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i : map.values()) {
            if (max <= i) {
                max = i;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (max == map.get(i)) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
