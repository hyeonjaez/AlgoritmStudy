import java.util.*;
import java.io.*;

public class Main {
    static int target;
    static int count;
    static List<Integer> list;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            target = Integer.parseInt(st.nextToken());
            count = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            list.add(target);
            int result = target;

            while (true) {
                result = hihi(result);
                if (list.contains(result)) {
                    break;
                }
                list.add(result);
            }

            int index = list.indexOf(result);

            System.out.println(index);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int hihi(int t) {
        int sum = 0;

        while (t > 0) {
            int a = t % 10;

            sum += (int) Math.pow(a, count);
            t /= 10;
        }

        return sum;
    }


}
