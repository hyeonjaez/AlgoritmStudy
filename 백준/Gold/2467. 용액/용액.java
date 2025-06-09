import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int[] result = new int[2];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int now = array[i];

            int start = i + 1;
            int end = n - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int sum = now + array[mid];

                if (Math.abs(sum) < min) {
                    result[0] = now;
                    result[1] = array[mid];
                    min = Math.abs(sum);
                }

                if (sum < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        System.out.println(result[0] + " " + result[1]);


    }


}

