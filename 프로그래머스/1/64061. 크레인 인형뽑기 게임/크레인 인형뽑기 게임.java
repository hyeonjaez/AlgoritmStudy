import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Queue<Integer>[] queues = new Queue[board[1].length];
        
        for(int i = 0; i < board[1].length; i++){
            queues[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[1].length; j++){
                if(board[i][j] != 0){
                    queues[j].add(board[i][j]);
                }
            }
        }
        
        Stack<Integer> stacks = new Stack<>();
        
        for(int i : moves){
            if(!queues[i - 1].isEmpty()){
                int a = queues[i - 1].poll();
                if(!stacks.isEmpty()){
                    if(stacks.peek() == a){
                    stacks.pop();
                    answer+=2;
                    continue;
                }
                }
                
                    stacks.add(a);
                
                
            }
        }
        
        
        return answer;
    }
}