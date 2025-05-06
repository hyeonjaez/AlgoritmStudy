import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String str : cities) {
            String target = str.toUpperCase();

            if (queue.contains(target)) {
                queue.remove(target);
                queue.add(target);
                answer += 1;
            } else {
                if (queue.size() >= cacheSize) {
                    queue.poll();
                }
                queue.add(target);
                answer += 5;
            }
        }
        return answer;
    }
}