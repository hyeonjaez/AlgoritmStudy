import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int start = 1;

        int end = array[n - 1];
        while (start <= end) {
            int mid = (start + end) / 2;

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (array[i] >= mid) {
                    count += array[i] / mid;
                }
            }

            if (count >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);


    }
}

 