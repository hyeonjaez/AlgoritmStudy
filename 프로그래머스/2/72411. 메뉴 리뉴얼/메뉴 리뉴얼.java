import java.util.*;

class Solution {
    
    char[] chars;
    int max;

    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();


        for (int ors : course) {
            Map<String, Integer> map = new HashMap<>();
            max = 0;
            for (String order : orders) {
                char[] orderChar = order.toCharArray();
                Arrays.sort(orderChar);
                chars = new char[ors];
                back(ors, 0, 0, orderChar, map);
            }

            for (Map.Entry<String, Integer> m : map.entrySet()) {
                if (m.getValue() >= 2 && m.getValue() == max) {
                    result.add(m.getKey());
                }
            }
        }



        return result.stream().

                sorted().

                toArray(String[]::new);
    }

    public void back(int number, int depth, int start, char[] target, Map<String, Integer> map) {
        if (number == depth) {
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }

            if (map.containsKey(sb.toString())) {
                map.put(sb.toString(), map.get(sb.toString()) + 1);
            } else {
                map.put(sb.toString(), 1);
            }

            max = Math.max(max, map.get(sb.toString()));
            return;
        }

        for (int i = start; i < target.length; i++) {
            chars[depth] = target[i];
            back(number, depth + 1, i + 1, target, map);
        }
    }
}

