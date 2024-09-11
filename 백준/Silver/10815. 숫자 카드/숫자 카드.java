import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] find = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(find);

        for (int i : targets) {
            System.out.print(isFind(find, i) + " ");
        }
    }

    public static int isFind(int[] find, int target) {
        int left = 0;
        int right = find.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (find[mid] == target) {
                return 1;
            }
            if (find[mid] > target) {
                right = mid - 1;
                continue;
            }

            if (find[mid] < target) {
                left = mid + 1;
            }
        }
        return 0;
    }
}