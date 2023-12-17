import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = ch.length - 1; j >= 0; j--) {
                int pow = (int) Math.pow(10, ch.length - 1 - j);
                map.put(ch[j] - 'A', map.getOrDefault(ch[j] - 'A', 0) + pow);
            }
        }

        List<Integer> keyList = map.keySet().stream().collect(Collectors.toList());
        Collections.sort(keyList, Comparator.comparingInt(map::get));

        int total = 0;
        int num = 10 - map.size();
        for (int key : keyList) {
            total += map.get(key) * num;
            num++;
        }

        System.out.println(total);
    }

}