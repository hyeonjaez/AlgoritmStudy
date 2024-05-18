import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String S = br.readLine();
            StringBuilder sb = new StringBuilder(br.readLine());
            int n = sb.length();
            for (int i = n - 1; i > S.length() - 1; i--) {
                if (sb.charAt(i) == 'A') {
                    sb.deleteCharAt(i);
                } else {
                    sb.deleteCharAt(i);
                    sb.reverse();
                }
            }

            if (sb.toString().equals(S)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}