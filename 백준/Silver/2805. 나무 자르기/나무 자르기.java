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
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.comparingInt(Integer::intValue));
        int min = 0;
        int max = list.get(list.size() - 1);

        while (min <= max) {
            int mid = (min + max) / 2;
            long qwer = 0;
            for (int value : list) {
                if (value > mid) {
                    qwer += (value - mid);
                }
            }
            if (qwer < M) {
                max = mid - 1;
            } else{
                min = mid + 1;
            }
        }

        System.out.println(max);
    }
}