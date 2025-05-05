import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            a(map, survey[i], choices[i]);
        }


        StringBuilder sb = new StringBuilder();
        sb.append(result(map, 'R', 'T'));
        sb.append(result(map, 'C', 'F'));
        sb.append(result(map, 'J', 'M'));
        sb.append(result(map, 'A', 'N'));



        return sb.toString();
    }

    public char result(Map<Character, Integer> map, char first, char second) {
        int f = map.get(first);
        int b = map.get(second);

        if (f > b) {
            return first;
        } else if (f < b) {
            return second;
        }

        return first < second ? first : second;
    }

    public void a(Map<Character, Integer> map, String str, int number) {
        if (number > 4) {
            char ch = str.charAt(1);
            int a = map.get(ch);
            map.put(ch, a + number - 4);
        } else if (number < 4) {
            char ch = str.charAt(0);
            int a = map.get(ch);
            map.put(ch, a + 4 - number);
        }
    }
}