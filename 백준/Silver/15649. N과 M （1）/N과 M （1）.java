import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[] array;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb = new StringBuilder();

            visited = new boolean[N];
            array = new int[M];


            backtracking(N, M, 0);

            System.out.println(sb.toString());
        }
    }

    public static void backtracking(int N, int M, int depth) {
        if (depth == M) {
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = i + 1;
                backtracking(N, M, depth + 1);
                visited[i] = false;
            }
        }

    }

}