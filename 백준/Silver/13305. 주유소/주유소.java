import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        List<Long> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Long> city = new ArrayList<>();

        for (int i = 0; i < count - 1; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count - 1; i++) {
            city.add(Long.parseLong(st.nextToken()));
        }

        long result = city.get(0) * list.get(0);

        long preValue = city.get(0);

        for (int i = 1; i < count - 1; i++) {
            long a = list.get(i) * preValue;
            long b = list.get(i) * city.get(i);

            if (a >= b) {
                preValue = city.get(i);
                result += b;
            } else {
                result += a;
            }
        }

        System.out.println(result);


    }
}