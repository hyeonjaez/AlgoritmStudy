import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int taesu = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());


        if (n == 0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        Integer[] scores = new Integer[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores, Collections.reverseOrder());

        if (n == p && taesu <= scores[scores.length - 1]) {
            System.out.println(-1);
        } else {
            int rank = 1;
            for (int i = 0; i < scores.length; i++) {
                if (taesu < scores[i]) {
                    rank++;
                } else {
                    break;
                }

            }
            System.out.println(rank);
        }


    }
}

class Node {
    int number;
    int rank;

    public Node(int number, int rank) {
        this.number = number;
        this.rank = rank;
    }
}