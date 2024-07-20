import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String str = br.readLine();

            int[] arr = new int[26];
            Arrays.fill(arr, -1);

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (arr[c - 'a'] == -1) {
                    arr[c - 'a'] = i;
                }
            }

            for (int a : arr) {
                System.out.print(a + " ");
            }

        }
    }


}
