import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        List<Node> nodeList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(a, b));
        }

        Collections.sort(nodeList);

        for (int i = 0; i < n; i++) {
            Node node = nodeList.get(i);

            if (pq.size() < node.deadLine) {
                pq.add(node.count);
            } else if (pq.size() == node.deadLine) {
                if (pq.peek() < node.count) {
                    pq.poll();
                    pq.add(node.count);
                }
            }
        }

        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);


    }
}


class Node implements Comparable<Node> {
    int deadLine;
    int count;

    public Node(int deadLine, int count) {
        this.deadLine = deadLine;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        if (this.deadLine == o.deadLine) {
            return o.count - this.count;
        }

        return this.deadLine - o.deadLine;
    }
}