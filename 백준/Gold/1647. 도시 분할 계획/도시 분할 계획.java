import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Edge[] array;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        init();

        array = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            array[i] = new Edge(a, b, value);
        }

        Arrays.sort(array);

        int selectTotalValue = 0;
        int bigCost = 0;
        for (int i = 0; i < array.length; i++) {
            Edge now = array[i];

            if (union(now.start, now.end)) {
                selectTotalValue += now.value;
                bigCost = now.value;
            }


        }

        System.out.println(selectTotalValue - bigCost);

    }

    public static void init() {
        parents = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[aRoot] = bRoot;
        return true;
    }


}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int value;

    Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}