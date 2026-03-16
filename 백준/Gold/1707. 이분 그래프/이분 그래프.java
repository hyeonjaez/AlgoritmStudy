import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v;
    static int e;
    static List<Integer>[] list;
    static int[] color;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int z = 0; z < t; z++) {
            st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new List[v + 1];

            for (int i = 1; i <= v; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            color = new int[v + 1];

            boolean isBipartite = true;

            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");


        }

        System.out.println(sb.toString());

    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        color[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list[now]) {
                if (color[next] == 0) {
                    color[next] -= color[now];
                    queue.offer(next);
                } else if (color[next] == color[now]) {
                    return false;
                }
            }
        }

        return true;
    }


}