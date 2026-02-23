import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] money = new int[n];

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }


        int answer = 0;

        for (int i = n - 1; i >= 0; i--) {
            int now = money[i];

            if (now > target) {
                continue;
            }

            answer += (target / now);
            target %= now;

            if(target <= 0){
                break;
            }
        }

        System.out.println(answer);

    }


}

