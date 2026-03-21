import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(st.nextToken());

        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(n, m);
            } else {
                if (isUnion(n, m)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static int find(int n) {
        if (array[n] == n) {
            return n;
        }

        return array[n] = find(array[n]);
    }

    public static boolean isUnion(int a, int b) {
        return find(a) == find(b);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            array[fa] = fb;
        }
    }
}
