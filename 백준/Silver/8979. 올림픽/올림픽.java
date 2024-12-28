import java.io.*;
import java.util.*;

public class Main {
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][3];
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gem = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            int dong = Integer.parseInt(st.nextToken());
            map[index][0] = gem;
            map[index][1] = en;
            map[index][2] = dong;
            maps.put(index, 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                if (a(map[i], map[j]) == 1) {
                    maps.put(i, maps.get(i) + 1);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(maps.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        int prevValue = -1;
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : list) {
            int currentValue = entry.getValue();
            if (currentValue != prevValue) {
                rank += count;
                count = 1;
            } else {
                count++;
            }
            rankMap.put(entry.getKey(), rank);
            prevValue = currentValue;
        }

        System.out.println(rankMap.get(target));

    }

    public static int a(int[] a, int[] b) {
        if (a[0] > b[0]) {
            return 1;
        } else if (a[0] < b[0]) {
            return -1;
        } else {
            if (a[1] > b[1]) {
                return 1;
            } else if (a[1] < b[1]) {
                return -1;
            } else {
                return Integer.compare(a[2], b[2]);
            }
        }
    }


}