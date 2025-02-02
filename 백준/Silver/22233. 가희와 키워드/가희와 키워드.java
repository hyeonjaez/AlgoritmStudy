import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }

        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(",");
            for (String str : split) {
                if(map.containsKey(str) && map.get(str) == 1) {
                    n--;
                    map.put(str, 0);
                }
            }

            System.out.println(n);

        }


    }

}