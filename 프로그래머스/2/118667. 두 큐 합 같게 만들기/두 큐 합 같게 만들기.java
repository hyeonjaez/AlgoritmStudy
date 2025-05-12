import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();
        
        
        long firstCount = 0;
        for (int number : queue1) {
            first.add(number);
            firstCount += number;
        }

        long secondCount = 0;
        for (int number : queue2) {
            second.add(number);
            secondCount += number;
        }

        long target = (firstCount + secondCount) / 2;
int size = first.size() + second.size();
        while (answer < size * 4) {
            if (firstCount == secondCount) {
                break;
            }

            if (firstCount > secondCount) {
                int pollFirst = first.poll();
                firstCount -= pollFirst;

                second.add(pollFirst);
                secondCount += pollFirst;
            } else {
                int pollSecond = second.poll();
                secondCount -= pollSecond;

                first.add(pollSecond);
                firstCount += pollSecond;
            }

            answer++;
        }


        return firstCount == secondCount ? answer : -1;
    }
}