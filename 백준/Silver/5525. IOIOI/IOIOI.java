import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            String str = "IOI";
            StringBuilder builder = new StringBuilder(str);
            for (int i = 1; i < n; i++) {
                builder.append("OI");
            }

            String a = builder.toString();

            String target = br.readLine();
            int sum = 0;
            for (int i = 0; i < target.length() - a.length() + 1; i++) {
                String sub = target.substring(i, i + a.length());
                if (sub.equals(a)) {
                    sum++;
                }

            }

            System.out.println(sum);


        }
    }


}
