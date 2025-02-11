import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int test = 0; test < n; test++) {
            String target = br.readLine();
            int targetCount = Integer.parseInt(br.readLine());

            if (targetCount == 1) {
                System.out.println("1 1");
                continue;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            int[] array = new int[26];

            for (int i = 0; i < target.length(); i++) {
                array[target.charAt(i) - 'a']++;
            }


            for (int i = 0; i < target.length(); i++) {
                if (array[target.charAt(i) - 'a'] < targetCount) {
                    continue;
                }

                int count = 1;

                for (int j = i + 1; j < target.length(); j++) {
                    if (target.charAt(j) == target.charAt(i)) {
                        count++;
                    }

                    if (count == targetCount) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);

            } else {
                System.out.println(min + " " + max);
            }


        }


    }


}