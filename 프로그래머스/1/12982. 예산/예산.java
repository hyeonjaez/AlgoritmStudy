import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int num = 0;
        for(int a : d){
            num += a;
            if(budget < num){
                break;
            }else{
                answer++;
            }
        }
        
        
        
        
        
    
        return answer;
    }
}