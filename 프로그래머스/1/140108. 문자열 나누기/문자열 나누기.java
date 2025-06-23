class Solution {
    public int solution(String s) {
        int answer = 0;
        int firstCount =0;
        int dCount = 0;
        
        char first = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++){
            if(firstCount == dCount && firstCount != 0){
                answer++;
                firstCount = 0;
                dCount =0;
                first = s.charAt(i);
            }
            
            if(first == s.charAt(i)){
                firstCount++;
            }else{
                dCount++;
            }
        }
        return answer +1;
    }
}