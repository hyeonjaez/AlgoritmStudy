import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int distance = b - a;
            int max = (int) Math.sqrt(distance);

            if (max == Math.sqrt(distance)) {
                System.out.println(max * 2 - 1);
            } else if (distance <= max * max + max) {
                System.out.println(max * 2);
            } else {
                System.out.println(max * 2 + 1);
            }
        }


    }
}