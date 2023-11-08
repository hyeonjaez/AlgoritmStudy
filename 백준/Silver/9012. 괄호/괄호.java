import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine().trim().split(""));
        }

        for (String[] s : list) {
            System.out.println(check(s));
        }

    }

    public static String check(String[] strings) {
        Stack<String> stack = new Stack<>();
        for (String s : strings) {
            if (Objects.equals(s, "(")) {
                stack.push(s);
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }


}