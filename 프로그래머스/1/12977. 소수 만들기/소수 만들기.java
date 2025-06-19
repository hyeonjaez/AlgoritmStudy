class Solution {
    int n;
    int m;
    int answer;
    int[] result;
    public int solution(int[] nums) {
        answer = 0;

        boolean[] visited = new boolean[nums.length];
        n = nums.length;
        m = 3;
        result = new int[3];
        dfs(0, 0, nums);
        
        return answer;
    }
    
    
    public void dfs(int start, int depth, int[] array){
        if(depth == m){
            int count =0;
            for(int i : result){
                count += i;
            }
            isPrime(count);
            return;
        }
        
        for(int i = start; i < array.length; i++){
            result[depth] = array[i];
            dfs(i + 1, depth+1, array);
            
        }
    }
    
    public void isPrime(int number){
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                
                return;
            }
        }
        answer++;
    }
}