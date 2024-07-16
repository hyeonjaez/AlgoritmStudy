import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st;
            String str;
            while ((str = br.readLine()) != null) {
                st = new StringTokenizer(str);
                String str1 = st.nextToken();
                String str2 = st.nextToken();

                int index = 0;

                for (int i = 0; i < str2.length(); i++) {
                    if (str1.charAt(index) == str2.charAt(i)) {
                        index++;
                    }
                    if (index == str1.length()) {
                        break;
                    }
                }

                if (index == str1.length()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}