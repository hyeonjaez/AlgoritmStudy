import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        PriorityQueue<Integer> room = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        room.add(queue.poll().end);

        int result = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (room.peek() <= now.start) {
                room.poll();
                room.add(now.end);
                continue;
            }

            room.add(now.end);
        }

        System.out.println(room.size());
    }
}

class Node implements Comparable<Node> {
    int start;
    int end;

    Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}