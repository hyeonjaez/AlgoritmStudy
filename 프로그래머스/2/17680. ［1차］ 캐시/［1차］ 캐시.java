import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        for (String st : cities) {
            String str = st.toUpperCase();
            if (queue.contains(str)) {
                answer += 1;
                queue.remove(str);
                queue.add(str);
                continue;
            } else {
                queue.add(str);
                answer += 5;
            }

            if (queue.size() > cacheSize) {
                queue.poll();
            }

        }

        return answer;
    }
}