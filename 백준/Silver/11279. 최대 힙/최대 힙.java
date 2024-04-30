import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                int calculation = Integer.parseInt(br.readLine());
                if (calculation == 0) {
                    if (queue.isEmpty()) {
                        bw.write(0 + "\n");
                    } else {
                        bw.write(queue.poll() + "\n");
                    }
                } else {
                    queue.offer(calculation);
                }
            }

        }
    }
}