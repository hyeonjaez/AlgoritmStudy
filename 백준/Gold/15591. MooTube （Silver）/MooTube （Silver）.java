import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        List<Node>[] map = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int us = Integer.parseInt(st.nextToken());

            map[a].add(new Node(b, us));
            map[b].add(new Node(a, us));

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];

            queue.add(end);
            visited[end] = true;
            int count = 0;
            while(!queue.isEmpty()){
                int now = queue.poll();

                for(Node node : map[now]){
                    if(!visited[node.target] && node.usado >= start){
                        count++;
                        queue.add(node.target);
                        visited[node.target] = true;
                    }
                }
            }
            sb.append(count).append("\n");

        }
        System.out.println(sb);


    }
}

class Node {
    int target;
    int usado;

    Node(int target, int usado) {
        this.target = target;
        this.usado = usado;
    }
}