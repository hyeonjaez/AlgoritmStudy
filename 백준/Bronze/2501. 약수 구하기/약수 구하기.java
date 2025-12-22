import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k){
        int number = 0;
        for(int i = 1; i <=n; i++){
            if(n % i == 0){
                number++;
            }

            if(number == k){
                return i;
            }
        }

        return 0;
    }
}
