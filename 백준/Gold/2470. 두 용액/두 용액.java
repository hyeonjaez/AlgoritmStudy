import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            if (2 > N || N > 100000) {
                throw new RuntimeException("N 입력을 다시하세요");
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            list.sort(Comparator.comparingInt(Integer::intValue));

            int left = 0;
            int right = N - 1;
            int min = Integer.MAX_VALUE;

            int[] result = new int[2];
            while (left < right) {
                int sum = list.get(left) + list.get(right);
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    result[0] = list.get(left);
                    result[1] = list.get(right);
                    if (sum == 0) {
                        break;
                    }
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

            System.out.println(result[0] + " " + result[1]);
        }
    }
}