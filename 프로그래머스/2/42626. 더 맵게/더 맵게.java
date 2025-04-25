import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i : scoville){
            queue.add(i);
        }
        
        while(queue.peek() < K && queue.size() >= 2){
            int a = queue.poll();
            int b = queue.poll();
            answer++;
            queue.add(a + (b * 2));
        }
        
        
        if(queue.peek() < K){
            return -1;
        }
        
        return answer;
    }
}