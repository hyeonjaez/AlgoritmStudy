import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] array = br.readLine().split("\\*");
        Pattern pattern = Pattern.compile(array[0] + ".*" + array[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String target = br.readLine();
            Matcher matcher = pattern.matcher(target);

            if (matcher.matches()) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }

        System.out.println(sb);
    }
}