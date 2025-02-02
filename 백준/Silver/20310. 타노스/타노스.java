import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int zeroCount = 0;
        int oneCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '0') {
                zeroCount++;
                continue;
            }
            oneCount++;
        }
        zeroCount /= 2;
        oneCount /= 2;

        int countZero = 0;
        int countOne = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '1') {
                if (countOne == oneCount) {
                    sb.append(target.charAt(i));
                    continue;
                }
                countOne++;
            } else {
                if (countZero == zeroCount) {
                    continue;
                }
                sb.append(target.charAt(i));
                countZero++;
            }
        }

        System.out.println(sb);


    }

}