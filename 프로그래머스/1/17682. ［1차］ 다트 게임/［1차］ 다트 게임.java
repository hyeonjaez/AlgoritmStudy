class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        int[] score = new int[3];
        int nowScore = 0;
        int index = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            if ('0' <= dartResult.charAt(i) && dartResult.charAt(i) <= '9') {
                nowScore = dartResult.charAt(i) - '0';

                if ('0' <= dartResult.charAt(i+1) && dartResult.charAt(i+1) <= '9'){
                    nowScore *= 10;
                    i++;
                }

                index++;
                continue;
            }

            char now = dartResult.charAt(i);
            int calScore = 0;
            switch (now) {
                case 'S':
                    score[index] = nowScore;
                    break;
                case 'D':
                    calScore = (int) Math.pow(nowScore, 2);
                    score[index] = calScore;
                    break;
                case 'T':
                    calScore = (int) Math.pow(nowScore, 3);
                    score[index] = calScore;
                    break;
                case '*':
                    if(index - 1 >= 0){
                        score[index - 1] *= 2;
                    }
                    score[index] *= 2;
                    break;
                case '#':
                    score[index] *= -1;
                    break;
            }


        }

        for(int i : score){
            answer += i;
        }

        return answer;


    }
}