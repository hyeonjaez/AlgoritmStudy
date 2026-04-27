import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            array[i] = now;
        }

        Arrays.sort(array);

        int left = 0;
        int right = n - 1;

        int answerLeft = array[left];
        int answerRight = array[right];

        int min = Math.abs(array[left] + array[right]);

        while (left < right) {
            int sum = array[left] + array[right];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answerLeft = array[left];
                answerRight = array[right];
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(answerLeft + " " + answerRight);


    }


}
