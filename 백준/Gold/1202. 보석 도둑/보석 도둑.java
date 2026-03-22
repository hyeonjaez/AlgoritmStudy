
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        Dia[] dias = new Dia[n];
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dias[i] = new Dia(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }


        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dias, (a, b) -> a.weight - b.weight);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int idx = 0;

        for (int i = 0; i < k; i++) {
            while (idx < n && dias[idx].weight <= bags[i]) {
                pq.offer(dias[idx].count);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);


    }


}

class Dia {
    int weight;
    int count;

    Dia(int weight, int count) {
        this.weight = weight;
        this.count = count;
    }
}
