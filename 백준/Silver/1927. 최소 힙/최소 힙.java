import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int count = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new PriorityQueue<>();
            int number;
            for (int i = 0; i < count; i++) {
                number = Integer.parseInt(br.readLine());
                if (number == 0) {
                    if (Objects.isNull(queue.peek())) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    queue.poll();
                } else {
                    queue.add(number);
                }

            }
            System.out.println(sb.toString());
        }
    }
}

