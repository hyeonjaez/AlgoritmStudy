import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();

        String value = br.readLine();
        int regexSize = value.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < target.length(); i++) {
            stack.push(target.charAt(i));

            if (stack.size() >= regexSize) {
                boolean flag = true;

                for (int j = 0; j < regexSize; j++) {
                    if (stack.get(stack.size() - regexSize + j) != value.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < regexSize; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : stack) {
            sb.append(ch);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());


    }


}

