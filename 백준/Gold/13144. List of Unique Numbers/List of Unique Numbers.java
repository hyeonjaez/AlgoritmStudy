import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[100001];

        int r = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {
            while (r < n && !visited[array[r]]) {
                visited[array[r]] = true;
                r++;
            }

            answer += (r - i);

            visited[array[i]] = false;
        }
        System.out.println(answer);
    }





}
