import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int redCount = 0;
        int blueCount = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                redCount++;
                continue;
            }
            blueCount++;
        }

        int result = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                count++;
            } else {
                break;
            }
        }
        result = Math.min(result, redCount - count);

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'R') {
                count++;
            } else {
                break;
            }
        }
        result = Math.min(result, redCount - count);

        count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'B') {
                count++;
            } else {
                break;
            }
        }
        result = Math.min(result, blueCount - count);

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'B') {
                count++;
            } else {
                break;
            }
        }
        result = Math.min(result, blueCount - count);

        System.out.println(result);

    }

}
