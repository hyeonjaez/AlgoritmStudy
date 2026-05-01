import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        for (int cos : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {

                char[] chars = order.toCharArray();
                Arrays.sort(chars);

                back(cos, 0, 0, new char[cos], chars, map);
            }

            int max = 0;

            for (int count : map.values()) {
                if (count >= 2) {
                    max = Math.max(max, count);
                }
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max && max >= 2) {
                    result.add(key);
                }
            }

        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    public void back(int target, int depth, int start, char[] result, char[] chars, Map<String, Integer> map) {
        if (target == depth) {
            StringBuilder sb = new StringBuilder();

            for (char ch : result) {
                sb.append(ch);
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = start; i < chars.length; i++) {
            result[depth] = chars[i];

            back(target, depth + 1, i + 1, result, chars, map);
        }
    }
}