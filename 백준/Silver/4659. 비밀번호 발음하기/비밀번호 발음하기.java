import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (Objects.equals(line, "end")) {
                break;
            }

            String acc = "> is acceptable.\n";
            String not = "> is not acceptable.\n";


            char[] charArray = line.toCharArray();

            char prev = '.';
            int count = 0;
            boolean flag = false;
            for (char c : charArray) {
                if (isMoum(c)) {
                    flag = true;
                }

                if (isMoum(c) != isMoum(prev)) {
                    count = 1;
                } else {
                    count++;
                }

                if (count > 2 || prev == c && (c != 'e' && prev != 'o')) {
                    flag = false;
                    break;
                }
                prev = c;


            }
            if (flag) {
                sb.append("<").append(line).append(acc);
            } else {
                sb.append("<").append(line).append(not);
            }

        }
        System.out.println(sb);
    }

    public static boolean isMoum(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }



}