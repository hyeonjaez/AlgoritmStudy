import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[n + 1];
        int[] check = new int[n + 1];
        int[] build = new int[n + 1];

        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            build[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) {
                    break;
                }
                graph[a].add(i);
                check[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int a = queue.poll();

            for (int i : graph[a]) {
                check[i]--;
                result[i] = Math.max(result[i], result[a] + build[a]);
                if (check[i] == 0) {
                    
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + build[i]);
        }

    }
}