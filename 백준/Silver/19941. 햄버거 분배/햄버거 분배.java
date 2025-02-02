import java.io.*;
import java.util.*;

public class Main {
    static char[] info;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        info = br.readLine().toCharArray();
        result = 0;
        for (int i = 0; i < n; i++) {
            if (info[i] == 'P') {
                int index = Math.max(i - k, 0);

                boolean check = false;

                for (int j = index; j < i; j++) {
                    if (bergerCheck(j)) {
                        check = true;
                        break;
                    }
                }

                if (!check) {
                    if (i + k >= n) {
                        index = n - 1;
                    } else {
                        index = i + k;
                    }

                    for (int j = i + 1; j <= index; j++) {
                        if (bergerCheck(j)) {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(result);


    }

    static boolean bergerCheck(int index) {
        if (info[index] == 'H') {
            info[index] = 'X';
            result++;
            return true;
        }
        return false;
    }
}