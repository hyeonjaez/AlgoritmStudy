import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String st = Integer.toBinaryString(n);
            StringBuilder sb = new StringBuilder();

            for (int j = st.length() - 1; j >= 0; j--) {
                if (st.charAt(j) == '1') {
                    sb.append(st.length() - 1 - j).append(" ");
                }
            }

            System.out.println(sb);
        }
    }
}