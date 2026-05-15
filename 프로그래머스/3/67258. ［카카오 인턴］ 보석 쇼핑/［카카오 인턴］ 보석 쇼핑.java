import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Set<String> kinds = new HashSet<>(Arrays.asList(gems));
        int totalItem = kinds.size();

        int left = 0;
        int right = 0;

        int leftAnswer = 0;
        int rightAnswer = gems.length - 1;
        int minLength = gems.length;
        Map<String, Integer> map = new HashMap<>();

        while (right < gems.length) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            while (map.size() == totalItem) {
                int currentLength = right - left;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    leftAnswer = left;
                    rightAnswer = right;
                }

                map.put(gems[left], map.get(gems[left]) - 1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }

                left++;
            }

            right++;
        }


        return new int[]{leftAnswer + 1, rightAnswer+1};
    }
}