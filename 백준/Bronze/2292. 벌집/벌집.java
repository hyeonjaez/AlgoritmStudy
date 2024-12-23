import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int range = 2;
        int count = 1;

        while (range <= n) {
            range = range + (count * 6);
            count++;
        }

        System.out.println(count);


    }

}