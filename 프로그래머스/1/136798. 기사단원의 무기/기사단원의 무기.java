class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            int nowPower = getPower(i);
            
            if(nowPower > limit){
                answer+= power;
                continue;
            }
            
            answer += nowPower;
        }
        
        
        return answer;
    }
    
    public int getPower(int target){
        int count = 0;
        for(int i = 1; i * i <= target; i++){
            if(i * i == target){
                count++;
                continue;
            }
            
            if(target % i == 0){
                count+=2;
            }
            
            
        }
        return count;
    }
}