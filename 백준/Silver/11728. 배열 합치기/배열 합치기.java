import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();

            st = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < M; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);

            for (int number : list) {
                bufferedWriter.write(number + " ");
            }

            bufferedWriter.flush();
        }
    }
}