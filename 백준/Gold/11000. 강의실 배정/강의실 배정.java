import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        PriorityQueue<Integer> time = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Node poll = queue.poll();
        time.add(poll.end);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (time.peek() <= node.start) {
                time.poll();
                time.add(node.end);
            } else {
                time.add(node.end);
            }
        }

        System.out.println(time.size());


    }


}

class Node implements Comparable<Node> {
    int start;
    int end;

    public Node(int start, int end) {
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

