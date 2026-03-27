import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        array = new long[n];

        for (int i = 0; i < n; i++) {
            long now = Long.parseLong(br.readLine());

            if (i >= 1) {
                array[i] = array[i - 1] + now;
            } else {
                array[i] = now;
            }
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            if (command == 1) {
                long be;
                if (target == 1) {
                    be = array[target - 1];
                } else {
                    be = array[target - 1] - array[target - 2];
                }

                for (int j = target - 1; j < n; j++) {
                    array[j] = array[j] - be + value;
                }

            } else {
                int max = Math.max(target, (int) value) - 1;
                int min = Math.min(target, (int) value) - 1;

                if (min != 0) {
                    System.out.println(array[max] - array[min - 1]);
                } else {
                    System.out.println(array[max]);
                }
            }
        }
    }
}