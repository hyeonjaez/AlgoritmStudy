import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static Bus[] bus;
    static long[] distance;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bus = new Bus[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            bus[i] = new Bus(u, v, value);
        }

        distance = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distance[i] = INF;
        }

        if (bellmanford(1)) {
            System.out.println(-1);
        } else {
            for (int i = 2; i < n + 1; i++) {
                if (distance[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        }

    }

    public static boolean bellmanford(int start) {
        distance[start] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int now = bus[j].start;
                int next = bus[j].end;
                int cost = bus[j].value;

                if (distance[bus[j].start] == INF) {
                    continue;
                }

                if (distance[next] > (distance[now] + cost)) {
                    distance[next] = distance[now] + cost;

                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}

class Bus {
    int start;
    int end;
    int value;

    Bus(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}