import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Egg[] array;
    static int max = Integer.MIN_VALUE;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new Egg[n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ne = Integer.parseInt(st.nextToken());
            int we = Integer.parseInt(st.nextToken());
            array[i] = new Egg(ne, we);
        }
        dfs(0);
        System.out.println(max);

    }

    public static void dfs(int start) {
        if (start == n) {
            int number = 0;
            for (Egg e : array) {
                if (e.ne <= 0) {
                    number++;
                }
            }
            max = Math.max(number, max);
            return;
        }

        if (array[start].ne <= 0) {
            dfs(start + 1);
            return;
        }

        boolean hit = false;

        for (int i = 0; i < n; i++) {
            if (i == start) {
                continue;
            }
            if (array[i].ne <= 0) {
                continue;
            }

            hit = true;

            array[start].ne -= array[i].weight;
            array[i].ne -= array[start].weight;

            dfs(start + 1);

            array[start].ne += array[i].weight;
            array[i].ne += array[start].weight;

        }

        if (!hit) {
            dfs(start + 1);
        }
    }
}

class Egg {
    int ne;
    int weight;

    public Egg(int ne, int weight) {
        this.ne = ne;
        this.weight = weight;
    }
}