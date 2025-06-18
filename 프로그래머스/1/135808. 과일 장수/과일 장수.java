import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int sc : score) {
            pq.add(sc);
        }

        int index = 0;

        int count = 0;
        int min = 0;

        while (!pq.isEmpty()) {
            if (index != 0 && index % m == 0) {
                answer += (min * m);
            }

            min = pq.poll();


            index++;
        }

        if(index != 0 && index % m == 0) {
            answer += (min * m);
        }


        return answer;
    }
}