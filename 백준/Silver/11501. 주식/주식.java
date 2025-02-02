import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCount; i++) {
            int moneyCount = Integer.parseInt(br.readLine());
            int[] moneyArray = new int[moneyCount];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < moneyCount; j++) {
                moneyArray[j] = Integer.parseInt(st.nextToken());
            }

            int max = moneyArray[moneyCount - 1];
            long result = 0;
            for (int j = moneyCount - 2; j >= 0; j--) {
                if (max >= moneyArray[j]) {
                    result += max - moneyArray[j];
                }else{
                    max = moneyArray[j];
                }
            }
            sb.append(result).append("\n");

        }

        System.out.println(sb);


    }

}
