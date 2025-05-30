import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] line : lines) {
            for (int i = line[0] + 1; i <= line[1]; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        return (int) map.entrySet().stream().filter(entry -> entry.getValue() >= 2).count();
    }
}