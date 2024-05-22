import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int n;
    static int k;
    static boolean[] visited;
    static int[] cardList;
    static Set<String> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());

            cardList = new int[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                cardList[i] = Integer.parseInt(br.readLine());
            }

            makeNumber(0, "");

            System.out.println(hashSet.size());
        }


    }

    public static void makeNumber(int choiceIdx, String num) {
        if (choiceIdx == k) {
            hashSet.add(num);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNumber(choiceIdx + 1, num + cardList[i]);
                visited[i] = false;
            }
        }
    }
}