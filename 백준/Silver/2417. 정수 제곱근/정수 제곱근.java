import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long target = Long.parseLong(br.readLine());

        long start = 0;
        long end = target;

        long mid = 0;
        long result = 0;
        while (start <= end) {
            mid = (end + start) / 2;

            if (Math.pow(mid, 2) >= target) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }


}