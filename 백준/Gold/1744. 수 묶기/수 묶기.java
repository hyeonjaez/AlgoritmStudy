import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        List<Integer> plus = new ArrayList<>();

        List<Integer> minus = new ArrayList<>();

        int oneCount = 0;

        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > 1) {
                plus.add(number);
            } else if (number == 1) {
                oneCount++;
            } else if (number == 0) {
                zeroCount++;
            } else {
                minus.add(number);
            }
        }

        plus.sort(Collections.reverseOrder());
        Collections.sort(minus);

        int result = 0;

        for (int i = 0; i < plus.size(); i += 2) {
            if (i + 1 < plus.size()) {
                result += plus.get(i) * plus.get(i + 1);
            } else {
                result += plus.get(i);
            }
        }

        for (int i = 0; i < minus.size(); i += 2) {

            if (i + 1 < minus.size()) {

                result += minus.get(i) * minus.get(i + 1);

            } else {

                if (zeroCount == 0) {

                    result += minus.get(i);

                }

            }

        }

        result += oneCount;

        System.out.println(result);


    }


}
