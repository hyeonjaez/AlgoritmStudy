import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] array;
    static int[] target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        target = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();

        for (int i : target) {
            sb.append(isFind(i)).append(" ");
        }

        System.out.println(sb);
    }

    public static int isFind(int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == array[mid]) {
                return 1;
            }

            if (target < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }


}
