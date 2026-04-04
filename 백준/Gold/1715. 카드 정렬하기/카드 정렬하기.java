
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        if (queue.isEmpty() || queue.size() == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        while (queue.size() > 1) {
            int now = queue.poll() + queue.poll();
            answer += now;

            queue.add(now);
        }

        System.out.println(answer);

    }

}