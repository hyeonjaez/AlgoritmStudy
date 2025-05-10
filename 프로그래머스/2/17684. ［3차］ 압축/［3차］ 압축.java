import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        int number = init(map);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < msg.length(); i++) {
            char now = msg.charAt(i);

            if (map.containsKey(String.valueOf(now))) {

            }
        }
        int index = 0;

        while (index < msg.length()) {
            String str = "";

            while (index < msg.length()) {
                if (map.containsKey(str + msg.charAt(index))) {
                    str += msg.charAt(index);
                    index++;
                } else {
                    break;
                }
            }

            list.add(map.get(str));

            if (index < msg.length()) {
                map.put(str + msg.charAt(index), number++);
            }
        }


        return list.stream().mapToInt(i -> i).toArray();
    }

    public int init(Map<String, Integer> map) {
        int count = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), count);
            count++;
        }

        return count;
    }
}