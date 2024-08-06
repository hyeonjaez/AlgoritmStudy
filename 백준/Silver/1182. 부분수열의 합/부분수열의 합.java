import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int target;
    static int[] array;
    static int[] result;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            array = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            for (int i = 1; i <= n; i++) {
                visited = new boolean[n];
                result = new int[i];
                dfs(0, 0, i);
            }

            System.out.println(count);


        }
    }

    public static void dfs(int start, int depth, int targetDepth) {
        if (depth == targetDepth) {
            int sum = 0;
            for (int data : result) {
                sum += data;
            }
            if (sum == target) {
                count++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = array[i];
                dfs(i + 1, depth + 1, targetDepth);
                visited[i] = false;
            }


        }
    }


}

