import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] numbers;
    static List<Integer> groupA;
    static List<Integer> groupB;
    static List<List<Integer>> list;
    static boolean[] visited;
    static boolean[] selected;
    static int minResult;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        visited = new boolean[n + 1];
        selected = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        minResult = Integer.MAX_VALUE;
        subset(0);
        if (minResult == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(minResult);
    }

    public static void subset(int idx) {
        if (idx == n) {

            groupA = new ArrayList<>();
            groupB = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (selected[i]) {
                    groupA.add(i);
                } else {
                    groupB.add(i);
                }
            }

            if (groupA.size() == 0 || groupB.size() == 0) {
                return;
            }

            if (check(groupA) && check(groupB)) {
                int A = 0;
                int B = 0;
                for (int i : groupA) {
                    A += numbers[i];
                }

                for (int i : groupB) {
                    B += numbers[i];
                }

                minResult = Math.min(minResult, Math.abs(A - B));
            }

            return;
        }

        selected[idx] = true;
        subset(idx + 1);
        selected[idx] = false;
        subset(idx + 1);
    }

    public static boolean check(List<Integer> group) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        visited[group.get(0)] = true;
        queue.add(group.get(0));

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i : list.get(poll)) {
                if (!visited[i] && group.contains(i)) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        for (int i : group) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

}