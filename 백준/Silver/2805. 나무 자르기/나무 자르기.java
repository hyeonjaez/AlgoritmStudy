import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int left = 0;
        int right = trees[n - 1];

        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            if (sum < goal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        System.out.println(right);

    }
}