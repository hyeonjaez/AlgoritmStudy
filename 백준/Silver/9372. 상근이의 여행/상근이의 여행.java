import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());

            for (int i = 0; i < T; i++) {
                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                for (int m = 0; m < M; m++) {
                    st = new StringTokenizer(br.readLine());
                }
                System.out.println(N - 1);
            }

        }
    }
}