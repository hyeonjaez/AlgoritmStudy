import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int minResult;

    static List<Node> homeList;
    static List<Node> chickenList;
    static Node[] chickens;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        homeList = new ArrayList<>();
        chickenList = new ArrayList<>();

        minResult = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(st.nextToken());

                if (now == 1) {
                    homeList.add(new Node(i, j));
                } else if (now == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }

        chickens = new Node[m];

        dfs(0,0);

        System.out.println(minResult);


    }

    public static void dfs(int start, int depth) {
        if (depth == m) {
            int sum = 0;

            for (Node node : homeList) {
                int minLength = Integer.MAX_VALUE;
                for (Node chicken : chickens) {
                    minLength = Math.min(minLength, Math.abs(node.x - chicken.x) + Math.abs(node.y - chicken.y));
                }
                sum += minLength;
            }

            minResult = Math.min(minResult, sum);
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            chickens[depth] = chickenList.get(i);
            dfs(i + 1, depth + 1);
        }
    }


}

class Node implements Comparable<Node> {
    int x;
    int y;
    int value;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int compareTo(Node o) {
        return o.value - this.value;
    }
}