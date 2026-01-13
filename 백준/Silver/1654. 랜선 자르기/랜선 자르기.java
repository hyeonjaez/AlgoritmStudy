import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        long[] array = new long[n];
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        long min = 1; 
        long max = array[n - 1];
        

        while(min <= max){
            long mid = (min + max) / 2;
            int count = 0;
            for(long i : array){
                count += (i) / mid;
            }

            if(count < target){
                max = mid - 1;
            }else{
                min = mid + 1;
            }

        }

        System.out.println(max);

    }

    
    
    
}