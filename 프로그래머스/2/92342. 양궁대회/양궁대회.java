import java.util.*;

class Solution {
    int maxDiff =0;
    int[] answer ={-1};
    int[] lion = new int[11];
    public int[] solution(int n, int[] info) {
        dfs(0, n, info);
        return answer;
    }
    
    void dfs(int idx, int remain, int[] apeach){
        if(idx == 11){
            if(remain>0){
                lion[10] += remain;
            }
            
            checkScore(apeach);
            
            if(remain > 0){
                lion[10] -= remain;
            }
            
            return;
        }
        
        if(remain > apeach[idx]){
            lion[idx] = apeach[idx] + 1;
            dfs(idx+ 1, remain-lion[idx], apeach);
            lion[idx] = 0;
        }
        
        dfs(idx + 1, remain, apeach);
    }
    
    void checkScore(int[] apeach){
        int lionScore = 0;
        int apeachScore = 0;
        
        for(int i = 0; i <11; i++){
            if(lion[i] == 0 && apeach[i] ==0){
                continue;
            }
            
            int score = 10-i;
            
            if(lion[i]> apeach[i]){
                lionScore+= score;
            }else{
                apeachScore += score;
            }
        }
        int diff = lionScore - apeachScore;
        
        if(diff <= 0){
            return;
        }
        
        if(diff > maxDiff){
            maxDiff = diff;
            answer = lion.clone();
        }else if(diff == maxDiff){
            if(isBetter(lion, answer)){
                answer = lion.clone();
            }
        }
    }
    
    boolean isBetter(int[] current, int[] saved){
        for (int i = 10; i >= 0; i--) {

            if (current[i] > saved[i]) {

                return true;

            } else if (current[i] < saved[i]) {

                return false;

            }

        }

        return false;
    }
}