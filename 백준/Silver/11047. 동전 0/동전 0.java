import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < N; i++) {
                queue.add(Integer.parseInt(br.readLine()));
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int money = queue.poll();
                if (K >= money) {
                    int a = K / money;
                    K -= (money * a);
                    count += a;
                }
            }

            System.out.println(count);
        }
    }
}