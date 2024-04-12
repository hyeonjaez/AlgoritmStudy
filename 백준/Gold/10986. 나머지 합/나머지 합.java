import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        long[] sumArray = new long[number + 1];
        long[] counting = new long[target];

        long count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < number + 1; i++) {
            sumArray[i] = (sumArray[i-1] + Integer.parseInt(st.nextToken())) % target;

            if(sumArray[i] == 0){
                count++;
            }

            counting[(int) sumArray[i]]++;
        }


        for (int i = 0; i < target; i++) {
            count += (counting[i] * (counting[i] - 1) / 2);
        }

        System.out.println(count);
    }
}