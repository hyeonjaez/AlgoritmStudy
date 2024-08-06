
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] array;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            array = new int[n];

            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            result = new int[m];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(array);
            dfs(0, 0);
            System.out.println(sb.toString());

        }
    }

    public static void dfs(int start, int depth) {
        if (depth == m) {
            for (int data : result) {
                sb.append(data).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = array[i];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }


}

