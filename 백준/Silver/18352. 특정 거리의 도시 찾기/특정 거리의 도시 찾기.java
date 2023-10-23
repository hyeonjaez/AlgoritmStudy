import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> list;
    static boolean[] visited;
    static int[] result;
    static List<Integer> resultList;

    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        result = new int[N + 1];
        resultList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);

        }

        BFS(X);
        findElement(result, K);
        if (!resultList.isEmpty()) {
            resultList.stream().forEach(System.out::println);
        } else {
            System.out.println(-1);
        }

    }

    public static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                for (int no : list.get(now)) {
                    if (!visited[no]) {
                        result[no] = count;
                        visited[no] = true;
                        queue.add(no);
                    }
                }
            }
            count++;
        }
    }

    public static void findElement(int[] arr, int k) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == k) {
                resultList.add(i);
            }
        }

    }
}
