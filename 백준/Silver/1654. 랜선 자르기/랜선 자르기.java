import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        list.sort(Comparator.comparingInt(Long::intValue));

        long min = 1;
        long max = list.get(list.size() - 1) + 1;

        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (long value : list) {
                count += (value / mid);

            }

            if (count < M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max);
    }
}