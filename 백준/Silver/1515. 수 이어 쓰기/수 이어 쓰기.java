import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int n = 0;
        int base = 0;

        while (base++ <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == str.charAt(n)) {
                    n++;
                }

                if (n == str.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }


        for (int i = 1; i <= 30000; i++) {

        }


    }
}