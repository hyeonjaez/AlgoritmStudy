import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        int count = 1;

        while (target > start) {
            if (target % 10 == 1) {
                target /= 10;
            } else if (target % 2 == 0) {
                target /= 2;
            } else {
                break;
            }
            count++;
        }

        if (target == start) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }


    }


}

