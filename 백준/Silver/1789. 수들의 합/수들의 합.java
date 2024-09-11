import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long target = Long.parseLong(br.readLine());

        long n = 1;
        long sum = 0;

        while (true) {
            sum += n;
            if (sum > target) {
                break;
            }
            n++;
        }

        System.out.println(n - 1);
    }
}