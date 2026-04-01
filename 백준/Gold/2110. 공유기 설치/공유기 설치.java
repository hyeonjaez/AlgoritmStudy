import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int low = 1;
        int hi = array[n - 1] - array[0] + 1;

        while (low < hi) {
            int mid = (hi + low) / 2;

            if (canInstall(mid) < c) {
                hi = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);

    }

    public static int canInstall(int mid) {
        int count = 1;
        int lastLocate = array[0];

        for (int i = 1; i < array.length; i++) {
            int locate = array[i];

            if (locate - lastLocate >= mid) {
                count++;
                lastLocate = locate;
            }
        }

        return count;

    }


}