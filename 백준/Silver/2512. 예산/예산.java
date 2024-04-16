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
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Comparator.comparingInt(value -> value));

        long M = Long.parseLong(br.readLine());
        long max = list.get(list.size() - 1);
        long min = 0;
        long maxCount = 0;

        while (min <= max) {
            long mid = (max + min) / 2;
            long sum = 0;

            for (int money : list) {
                sum += Math.min(money, mid);
            }

            if (sum > M) {
                max = mid - 1;
            } else {
                min = mid + 1;
                maxCount = Math.max(maxCount, mid);
            }
        }

        System.out.println(maxCount);


    }


}