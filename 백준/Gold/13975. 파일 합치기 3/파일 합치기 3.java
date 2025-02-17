import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] array;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Long> queue = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                queue.add(Long.parseLong(st.nextToken()));
            }
            long result = 0;

            while (!queue.isEmpty()) {
                long first = queue.poll();
                long second = 0;
                if (!queue.isEmpty()) {
                    second = queue.poll();

                    result += first + second;

                    queue.add(first + second);
                } else {
                    break;
                }

            }

            System.out.println(result);
        }
    }


}

