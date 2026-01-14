import java.util.*;
import java.io.*;

public class Main{



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i <t; i++){
            int answer = 1;
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n+1];
            StringTokenizer st;
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                array[a] = b;
            }

            int min = array[1];
            
            for(int ab = 2; ab< n+1; ab++){
                if(min > array[ab]){
                    answer++;
                    min = array[ab];
                }
            }
            System.out.println(answer);

        }
    }
}