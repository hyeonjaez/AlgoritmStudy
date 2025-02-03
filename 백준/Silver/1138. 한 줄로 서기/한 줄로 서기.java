import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 1; i <= n; i++) {
            int now = Integer.parseInt(st.nextToken());
            int count = 0;
            int bigCount = 0;
            for (int j = 1; j <= n; j++) {
                if (array[j] == 0) {
                    if (bigCount == now || count == now) {
                        array[j] = i;
                        break;
                    }

                    count++;
                } else {
                    if (array[j] > i) {
                        bigCount++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(array[i]).append(" ");
        }

        System.out.println(sb);

    }

}
