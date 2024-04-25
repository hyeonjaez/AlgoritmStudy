import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (Objects.equals(command, "push")) {
                    int number = Integer.parseInt(st.nextToken());
                    deque.offer(number);
                } else if (Objects.equals(command, "front")) {
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(deque.peekFirst() + "\n");
                    }

                } else if (Objects.equals(command, "back")) {
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(deque.peekLast() + "\n");
                    }
                } else if (Objects.equals(command, "size")) {
                    bw.write(deque.size() + "\n");
                } else if (Objects.equals(command, "empty")) {
                    if (deque.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                } else if (Objects.equals(command, "pop")) {
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(deque.pollFirst() + "\n");
                    }
                }
            }
            bw.flush();
        }
    }
}