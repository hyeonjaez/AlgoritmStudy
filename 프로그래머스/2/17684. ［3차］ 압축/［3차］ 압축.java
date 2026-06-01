import java.util.*;
class Solution {
    Map<String, Integer> map;

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        int count = 27;

        int index = 0;
        init();

        while (index < msg.length()) {
            String now = "";

            while (index < msg.length()) {
                if (map.containsKey(now + msg.charAt(index))) {
                    now += msg.charAt(index);
                    index++;
                } else {
                    break;
                }
            }

            answer.add(map.get(now));

            if (index < msg.length()) {
                map.put(now + msg.charAt(index), count++);
            }


        }


        return answer.stream().mapToInt(o -> o).toArray();
    }

    public void init() {
        map = new HashMap<>();

        char now = 'A';
        for (int i = 1; i < 27; i++) {
            map.put(String.valueOf(now), i);
            now++;
        }

    }
}