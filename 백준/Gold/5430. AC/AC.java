import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < testCount; i++) {
                String[] methods = br.readLine().split("");
                int dataCount = Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
//                Deque<Integer> queue = Arrays.stream(br.readLine()
//                                .replace("[", "")
//                                .replace("]", "").split(","))
//                        .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
                Deque<Integer> queue = new ArrayDeque<>();

                for (int j = 0; j < dataCount; j++) {
                    queue.add(Integer.parseInt(st.nextToken()));
                }
                AC(methods, queue, sb);
            }
            System.out.println(sb);
        }
    }

    public static void AC(String[] methods, Deque<Integer> deque, StringBuilder sb) {

        boolean isReverse = false;

        for (String method : methods) {
            if (Objects.equals("R", method)) {
                isReverse = !isReverse;
                continue;
            }

            if (isReverse) {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        makeResult(sb, deque, isReverse);
    }

    public static void makeResult(StringBuilder sb, Deque<Integer> deque, boolean isReverse) {
        sb.append("[");

        if (!deque.isEmpty()) {
            if (isReverse) {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
        }
        sb.append("]").append("\n");
    }
}