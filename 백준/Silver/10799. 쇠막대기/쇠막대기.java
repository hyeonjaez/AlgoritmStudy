import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] charArray = str.toCharArray();

        Stack<Character> stack = new Stack<>();
        int count = 0;
        char before = 0;

        for (char now : charArray) {
            if (now == '(') {
                stack.push(now);

            } else {
                if (before == '(') {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count++;
                }
            }
            before = now;
        }
        System.out.println(count);
    }
}

