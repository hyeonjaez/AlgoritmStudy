import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Deque<String> queue;
    static boolean isReverse;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        isReverse = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCount; i++) {
            String command = br.readLine();
            isReverse = false;
            queue = new ArrayDeque<>();
            int count = Integer.parseInt(br.readLine());

            String[] split = br.readLine().replace("[", "").replace("]", "").split(",");

            if(count> 0){
                Collections.addAll(queue, split);
            }



            char[] charArray = command.toCharArray();
            boolean isError = false;
            for (char c : charArray) {

                if (cm(c)) {
                    isError = true;
                    sb.append("error");
                    break;
                }
            }

            if (!isError) {
                sb.append("[");

                while (!queue.isEmpty()) {
                    if (!isReverse) {
                        sb.append(queue.pollFirst());
                    } else {
                        sb.append(queue.pollLast());
                    }

                    if (!queue.isEmpty()) {
                        sb.append(",");
                    }

                }
                sb.append("]");
            }

            if(i != testCount - 1){
                sb.append("\n");
            }

        }

        System.out.println(sb);

    }

    public static boolean cm(char command) {
        switch (command) {
            case 'R':
                isReverse = !isReverse;
                break;
            case 'D':
                if (queue.isEmpty()) {
                    return true;
                }

                if (!isReverse) {
                    queue.pollFirst();
                } else {
                    queue.pollLast();
                }
        }

        return false;
    }


}
