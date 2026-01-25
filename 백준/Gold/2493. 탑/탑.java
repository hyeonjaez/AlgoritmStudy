import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.push(new Top(i + 1, now));
                sb.append(0).append(" ");
                continue;
            }

            while (true) {
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                    stack.push(new Top(i + 1, now));
                    break;
                }

                if (stack.peek().height < now) {
                    stack.pop();
                } else {
                    sb.append(stack.peek().number).append(" ");
                    stack.push(new Top(i + 1, now));
                    break;
                }
            }
        }

        System.out.println(sb.toString());


    }
}

class Top {
    int number;
    int height;

    Top(int number, int height) {
        this.number = number;
        this.height = height;
    }
}