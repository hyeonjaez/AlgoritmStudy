import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for(String target : cities){
            target = target.toUpperCase();
            if(queue.contains(target)){
                answer += 1;
                queue.remove(target);
                queue.add(target);
                continue;
            }
            
            if(queue.size() >= cacheSize){
                queue.poll();
            }
            
            queue.add(target);
            answer += 5;
            
        }
        
        return answer;
    }
}