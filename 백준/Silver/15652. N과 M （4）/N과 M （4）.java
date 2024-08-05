import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] array;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            array = new int[M];
            sb = new StringBuilder();
            dfs(1, 0);

            System.out.println(sb.toString());

        }
    }

    public static void dfs(int data, int depth) {
        if (depth == M) {
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = data; i <= N; i++) {
            array[depth] = i;
            dfs(i, depth + 1);
        }
    }


}

