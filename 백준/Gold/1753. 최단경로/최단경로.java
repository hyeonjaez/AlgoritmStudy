import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v;
    static int e;
    static int start;
    static int[] array;
    static List<Node>[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        map = new List[v + 1];
        array = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            map[i] = new ArrayList<>();
        }

        Arrays.fill(array, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int now = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[now].add(new Node(index, weight));
        }

        da(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++){
            if(array[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
                continue;
            }
            
            sb.append(array[i]).append("\n");
        }

        System.out.println(sb.toString());


    }

    public static void da(int start) {
        Node startNode = new Node(start, 0);

        array[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();

            if (array[nowNode.end] < nowNode.weight) {
                continue;
            }

            for (Node nextNode : map[nowNode.end]) {
                int nextDistance = array[nowNode.end] + nextNode.weight;

                if (array[nextNode.end] > nextDistance) {
                    array[nextNode.end] = nextDistance;
                    queue.add(new Node(nextNode.end, nextDistance));
                }
            }
        }


    }


}

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }


}