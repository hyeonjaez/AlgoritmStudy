import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < range; i++) {
            max += array[i];
        }

        int temp = max;

        for (int i = range; i < n; i++) {
            temp = temp - array[i - range] + array[i];
            max = Math.max(max, temp);
        }

        System.out.println(max);


    }


}