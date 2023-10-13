import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Queue<Integer> queue = new PriorityQueue<>(list);

        int sum = 0;
        while (queue.size() > 1) {
            int now = queue.remove();
            int next = queue.remove();
            sum += now + next;
            queue.add(now + next);
        }


        System.out.println(sum);
    }
}