import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] map;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[100001];
            map[N] = 1;
            queue.add(N);

            System.out.println(bfs());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (poll == K) {
                return map[K] - 1;
            }
            if (poll - 1 >= 0 && map[poll - 1] == 0) {
                map[poll - 1] = map[poll] + 1;
                queue.add(poll - 1);
            }
            if (poll + 1 < 100001 && map[poll + 1] == 0) {
                map[poll + 1] = map[poll] + 1;
                queue.add(poll + 1);
            }
            if (poll * 2 < 100001 && map[poll * 2] == 0) {
                map[poll * 2] = map[poll] + 1;
                queue.add(poll * 2);
            }
        }
        return -1;
    }
}