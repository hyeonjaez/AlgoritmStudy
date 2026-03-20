import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        PriorityQueue<Number> queue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    Number poll = queue.poll();
                    sb.append(poll.count).append("\n");
                }

            } else {
                queue.add(new Number(command));
            }

        }
        System.out.println(sb);

    }
}

class Number implements Comparable<Number> {
    int count;
    int abs;

    Number(int count) {
        this.count = count;
        this.abs = Math.abs(count);
    }

    @Override
    public int compareTo(Number o) {
        if (this.abs == o.abs) {
            return this.count - o.count;
        }

        return this.abs - o.abs;
    }
}