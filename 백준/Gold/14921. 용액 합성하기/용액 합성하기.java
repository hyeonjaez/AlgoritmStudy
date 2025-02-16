import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] array;
    static int[] target;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        for (int i = 0; i < n; i++) {
            int now = array[i];

            int start = i + 1;
            int end = n - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                int sum = now + array[mid];

                if (Math.abs(sum) < Math.abs(min)) {
                    min = sum;
                }

                if (sum < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        System.out.println(min);


    }


}

