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

        init(n);
        for (int i = 1; i <= count; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (find(n) == find(m)) {
                System.out.println(i);
                return;
            }

            union(n, m);
        }

        System.out.println(0);
    }

    public static int find(int n) {
        if (array[n] == n) {
            return n;
        }

        return array[n] = find(array[n]);
    }

    public static void union(int n, int m) {
        int fn = find(n);
        int fm = find(m);

        if (fn != fm) {
            array[fn] = fm;
        }
    }

    public static void init(int n) {
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

}
