import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int number = 0;
        for(int i= 0; i< 10; i++){
            st = new StringTokenizer(br.readLine());
            int minus = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st.nextToken());

            number -= minus;
            number += plus;

            max = Math.max(max, number);
        }

        System.out.println(max);
    }

    
    
    
}