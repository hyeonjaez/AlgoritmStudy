import java.util.*;
import java.io.*;

public class Main{
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operation = new int[4];
    static int[] array;
    static int n;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());
        for(int i =0; i<4; i++){
            operation[i] = Integer.parseInt(st.nextToken());
        }

        back(array[0], 1);

        System.out.println(max);
        System.out.println(min);
        
    }

    public static void back(int number, int index){
        if(index == n){
            max = Math.max(number, max);
            min = Math.min(number, min);
            return;
        }

        for(int i = 0; i< 4; i++){
            int op = operation[i];

            if(op > 0){
                operation[i]--;
                switch(i) {
                    case 0:
                        back(number + array[index], index + 1);
                        break;
                    case 1:
                        back(number - array[index], index + 1);
                        break;
                    case 2:
                        back(number * array[index], index + 1);
                        break;
                    case 3:
                        back(number / array[index], index+ 1);
                        break;            
                }

                operation[i]++;
            }
        }
    }


    

    

}