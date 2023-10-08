import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Map<Integer, Integer> cards;
    static int M;
    static int[] find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cards = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (cards.get(number) == null) {
                cards.put(number, 1);
            } else {
                cards.put(number, cards.get(number) + 1);
            }
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int find = Integer.parseInt(st.nextToken());
            if (cards.get(find) == null) {
                sb.append(0).append(" ");
            } else {
                sb.append(cards.get(find)).append(" ");
            }
        }
        System.out.println(sb.toString());

    }
}