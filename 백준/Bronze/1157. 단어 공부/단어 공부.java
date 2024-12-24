import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[26];
        String string = br.readLine();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            array[ch - 'A']++;
        }

        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, array[i]);
        }
        char result = 0;
        int isDuplicate = 0;
        for (int i = 0; i < 26; i++) {
            if (array[i] == max) {
                isDuplicate++;
                result = (char) (i + 'A');
            }
        }

        if (isDuplicate > 1) {
            System.out.println("?");
        } else {
            System.out.println(result);
        }

    }

}