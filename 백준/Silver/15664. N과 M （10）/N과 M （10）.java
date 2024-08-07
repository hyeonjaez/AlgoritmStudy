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

            st = new StringTokenizer(br.readLine());
            array = new int[n];
            result = new int[m];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(array);

            dfs(0, 0);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }


    public static void dfs(int start, int depth) {
        if (depth == m) {
            for (int data : result) {
                System.out.print(data + " ");
            }
            System.out.println();
            return;
        }
        int before = 0;
        for (int i = start; i < array.length; i++) {
            if (!visited[i]) {
                if (before != array[i]) {
                    result[depth] = array[i];
                    visited[i] = true;
                    before = array[i];
                    dfs(i , depth + 1);
                    visited[i] = false;

                }

            }

        }

    }
}