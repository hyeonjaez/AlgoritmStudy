import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] result = {};
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        score[0] = checkAnswer(answers, first);
        score[1] = checkAnswer(answers, second);
        score[2] = checkAnswer(answers, third);
        
        int maxScore = Arrays.stream(score).max().orElse(0);
        
        List<Integer> maxScoreList = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++){
            if(maxScore == score[i]){
                maxScoreList.add(i + 1);
            }
        }
        
        int[] maxScoreArray = new int[maxScoreList.size()];
        for(int i = 0; i < maxScoreList.size(); i++){
            maxScoreArray[i] = maxScoreList.get(i);
        }
        
        return maxScoreArray;
    }
    
    public int checkAnswer(int[] answers, int[] pick) {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pick[i % pick.length]) {
                count++;
            }
        }
        return count;
    }
}