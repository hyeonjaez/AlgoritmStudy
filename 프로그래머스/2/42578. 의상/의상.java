import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] a : clothes) {
            map.put(a[1], map.getOrDefault(a[1], 0) + 1);
        }

        for (int value : map.values()) {
            answer *= (value + 1);
        }


        return answer - 1;
    }
}