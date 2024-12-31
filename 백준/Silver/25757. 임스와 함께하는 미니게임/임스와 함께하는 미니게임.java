import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map.put("Y", 2);
        map.put("F", 3);
        map.put("O", 4);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int count = map.get(st.nextToken());

        Set<String> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        result = set.size() / (count - 1);

        System.out.println(result);


    }
}