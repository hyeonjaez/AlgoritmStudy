import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nodes);

        int count = 0;
        long prevTime = 0;

        for (int i = 0; i < n; i++) {
            if (nodes[i].start >= prevTime) {
                count++;
                prevTime = nodes[i].end;
            }
        }

        System.out.println(count);

    }


}

class Node implements Comparable<Node> {
    long start;
    long end;

    public Node(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Node o) {
        if (this.end == o.end) {
            return (int) (this.start - o.start);
        }

        return (int) (this.end - o.end);
    }

}

