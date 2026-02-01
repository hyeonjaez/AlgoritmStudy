import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> answer;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static List<Integer>[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        array = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = new ArrayList<>();
        }


        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            int now = dfs(i);

            if (now > max) {
                max = now;
                answer = new ArrayList<>();
                answer.add(i);
            } else if (now == max) {
                answer.add(i);
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }


    }

    public static int dfs(int start) {
        visited[start] = true;

        int count = 1;

        for (int i : array[start]) {
            if (!visited[i]) {
                count += dfs(i);
            }
        }

        return count;
    }
}