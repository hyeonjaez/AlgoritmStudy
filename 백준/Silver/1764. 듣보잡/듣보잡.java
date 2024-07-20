import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(br.readLine());
            }

            List<String> list = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String target = br.readLine();
                if (set.contains(target)) {
                    list.add(target);
                }
            }
            Collections.sort(list);
            System.out.println(list.size());
            for (String str : list) {
                System.out.println(str);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
