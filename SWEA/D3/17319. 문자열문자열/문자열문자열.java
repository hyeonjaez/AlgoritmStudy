
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Solution
{
	public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(br.readLine());

            for (int i = 1; i <= testCount; i++) {
                int length = Integer.parseInt(br.readLine());
                String string = br.readLine();

                if (isMakeJaehyeon(length, string)) {
                    System.out.println("#" + i + " " + "Yes");
                } else {
                    System.out.println("#" + i + " " + "No");
                }
            }
        }

    }

   public static boolean isMakeJaehyeon(int length, String string) {
        if (length % 2 != 0) {
            return false;
        }
        String subString1 = string.substring(0, length / 2);
        String subString2 = string.substring(length / 2);
        return subString1.equals(subString2);
    }
}