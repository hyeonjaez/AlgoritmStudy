import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> list;
    static boolean[] visited;
    static int[] number;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        number = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        System.out.println(list.size());

        list.stream().forEach(System.out::println);


    }

    public static void dfs(int start, int target) {
        if (visited[number[start]] == false) {
            visited[number[start]] = true;
            dfs(number[start], target);
            visited[number[start]] = false;
        }

        if (number[start] == target) {
            list.add(target);
        }
    }


}
