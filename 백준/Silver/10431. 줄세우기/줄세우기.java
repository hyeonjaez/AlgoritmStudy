import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int testCount = Integer.parseInt(st.nextToken());
            array = new int[20];

            for (int j = 0; j < 20; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;

            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if (array[j] < array[k]) {
                        count++;
                    }
                }
            }

            System.out.println(testCount + " " + count);


        }

    }


}