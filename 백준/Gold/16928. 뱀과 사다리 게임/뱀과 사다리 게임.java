import java.io.*;
import java.util.*;

public class Main {
    static int[] map;
    static boolean[] visited;
    static int[] dice = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[101];
        visited = new boolean[101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
        }

        System.out.println(bfs(1));


    }

    public static int bfs(int start) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Move now = queue.poll();
            if (now.index == 100) {
                return now.count;
            }

            for (int i = 0; i < 6; i++) {
                int next = dice[i] + now.index;
                if (next < 101 && !visited[next]) {

                    if (map[next] != 0) {
                        next = map[next];
                    }
                    visited[next] = true;
                    queue.add(new Move(next, now.count + 1));
                }

            }
        }
        return -1;
    }

}

class Move {
    int index;
    int count;

    Move(int index, int count) {
        this.index = index;
        this.count = count;
    }
}
