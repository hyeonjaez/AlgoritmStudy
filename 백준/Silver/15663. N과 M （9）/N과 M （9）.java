
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            array = new int[n];
            result = new int[m];
            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(array);
            dfs(0);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int data : result) {
                System.out.print(data + " ");
            }
            System.out.println();

            return;
        }
        int before = 0;
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                if (before != array[i]) {
                    visited[i] = true;
                    result[depth] = array[i];
                    before = array[i];
                    dfs(depth + 1);
                    visited[i] = false;
                }

            }
        }
    }
}