import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : participant) {
            if (map.containsKey(s)) {
                int a = map.get(s);

                if (a > 0) {
                    map.put(s, a - 1);
                } else {
                    return s;
                }

            } else {
                return s;
            }
        }

        String answer = "";

        Set<String> strings = map.keySet();
        for (String s : strings) {
            if (map.get(s) > 0) {
                answer = s;
            }
        }


        return answer;
    }
}