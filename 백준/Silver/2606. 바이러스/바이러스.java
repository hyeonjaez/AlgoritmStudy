import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int result;
    static List<Integer>[] list;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(br.readLine());
            int count = Integer.parseInt(br.readLine());
            visited = new boolean[number + 1];

            list = new ArrayList[number + 1];

            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            StringTokenizer st;
            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
            }
            result = 0;
            dfs(1);
            System.out.println(result);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void dfs(int start) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;

        for (int a : list[start]) {
            if (!visited[a]) {
                result++;
                dfs(a);
            }
        }
    }
}