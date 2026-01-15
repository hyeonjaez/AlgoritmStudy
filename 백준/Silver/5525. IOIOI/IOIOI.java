import java.util.*;
import java.io.*;

public class Main{



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int strLength = Integer.parseInt(br.readLine());

        char[] array = br.readLine().toCharArray();
        int answer = 0;
        int count = 0;
        for(int i = 1; i < strLength - 1;){
            if(array[i] == 'O' && array[i + 1] == 'I'){
                count++;

                if(count == n){
                    if(array[i - (count * 2 - 1)] == 'I'){
                        answer++;
                    }
                    count--;
                }
                i += 2;
            }  else {
                count = 0;
                i++;
            }
        }
        System.out.println(answer);
    }
}