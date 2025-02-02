import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int beforeIndex = -1;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String target = br.readLine();

        int result = 0;

        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            int[] chars = new int[26];
            for (int j = 0; j < target.length(); j++) {
                chars[target.charAt(j) - 'A']++;
            }

            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                if (chars[str.charAt(j) - 'A'] > 0) {
                    chars[str.charAt(j) - 'A']--;
                    count++;
                }
            }

            if (str.length() == target.length() && (target.length() == count || target.length() - 1 == count)) {
                result++;
            }

            if (str.length() + 1 == target.length() && count == str.length()) {
                result++;
            }

            if (str.length() - 1 == target.length() && count == str.length() - 1) {
                result++;
            }
        }

        System.out.println(result);


    }

}