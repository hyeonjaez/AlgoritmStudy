import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Long, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long now = Long.parseLong(st.nextToken());
            map.put(now, map.getOrDefault(now, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            long now = Long.parseLong(st.nextToken());

            sb.append(map.getOrDefault(now, 0)).append(" ");
        }

        System.out.println(sb);


    }


}

