import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dataCount = Integer.parseInt(st.nextToken());
        int questionCount = Integer.parseInt(st.nextToken());
        long[] array = new long[dataCount + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= dataCount; i++) {
            array[i] = array[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < questionCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(array[end] - array[start - 1]);
        }
    }
}