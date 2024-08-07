import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb;

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
            sb = new StringBuilder();

            Arrays.sort(array);
            dfs(0);
            System.out.println(sb.toString());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int data : result) {
                sb.append(data).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;

        for (int i = 0; i < n; i++) {
            if (before != array[i]) {
                result[depth] = array[i];
                before = array[i];
                dfs(depth + 1);
            }

        }
    }


}