import java.io.*;

public class Main {


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            char[][] map = new char[5][15];
            int maxLength = 0;

            for (int i = 0; i < 5; i++) {
                String str = br.readLine();
                maxLength = Math.max(maxLength, str.length());

                for (int j = 0; j < str.length(); j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < maxLength; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[j][i] == '\0') {
                        continue;
                    }
                    
                    sb.append(map[j][i]);
                }
            }
            System.out.println(sb.toString());


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
