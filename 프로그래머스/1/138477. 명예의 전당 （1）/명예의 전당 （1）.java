import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        
        for(int sc : score){
            if(pqueue.size() < k){
                pqueue.add(sc);
            }else{
                if(pqueue.peek() < sc){
                    pqueue.poll();
                    pqueue.add(sc);
                }
            }
            
            
            result.add(pqueue.peek());
        }
        return result.stream().mapToInt(o -> o).toArray();
    }
}