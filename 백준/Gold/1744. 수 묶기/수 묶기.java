import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();


        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now > 1) {
                plus.add(now);
            } else if (now == 1) {
                oneCount++;
            } else if (now == 0) {
                zeroCount++;
            } else {
                minus.add(now);
            }
        }

        plus.sort(Collections.reverseOrder());
        Collections.sort(minus);

        int result = 0;
        for (int i = 0; i < plus.size(); i += 2) {
            if (plus.size() > i + 1) {
                result += (plus.get(i) * plus.get(i + 1));
            } else {
                result += plus.get(i);
            }
        }

        for (int i = 0; i < minus.size(); i += 2) {
            if (minus.size() > i + 1) {
                result += (minus.get(i) * minus.get(i + 1));
            } else {
                if (zeroCount == 0) {
                    result += minus.get(i);
                }
            }

        }

        result+= oneCount;

        System.out.println(result);


    }


}
