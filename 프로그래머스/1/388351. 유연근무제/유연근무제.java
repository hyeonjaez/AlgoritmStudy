import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int index = 0;

        for (int[] time : timelogs) {
            int maxTime = cal(schedules[index]);
            boolean flag = true;

            for (int j = 0; j < 7; j++) {
                int day = (startday + j) % 7;
                if (day % 7 > 0 && day % 7 < 6) {
                    if (time[j] > maxTime) {
                        flag = false;
                        break;
                    }

                }
            }


            if (flag) {
                answer++;
            }

            index++;
        }


        return answer;
    }

    public int cal(int target) {
        int hour = target / 100;
        int minute = target % 100;
        minute += 10;
        if (minute >= 60) {
            hour += 1;
            minute -= 60;
        }

        return hour * 100 + minute;
    }
}