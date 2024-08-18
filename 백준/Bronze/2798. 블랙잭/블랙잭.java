import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] array;
    static int n;
    static int m;
    static int minResult;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        result = new int[3];

        minResult = Integer.MAX_VALUE;
        back(0, 0);
        System.out.println(m - minResult);
    }

    public static void back(int start, int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int data : result) {
                sum += data;
            }

            if (sum > m) {
                return;
            }

            minResult = Math.min(minResult, m - sum);
            return;
        }
        for (int i = start; i < n; i++) {
            result[depth] = array[i];
            back(i + 1, depth + 1);
        }

    }

}