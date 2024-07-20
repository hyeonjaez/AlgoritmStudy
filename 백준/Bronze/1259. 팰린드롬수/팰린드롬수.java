import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                String str = br.readLine();

                StringBuilder sb = new StringBuilder(str);

                String reverse = sb.reverse().toString();

                if (str.equals("0")) {
                    break;
                }

                if (str.equals(reverse)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }


}
