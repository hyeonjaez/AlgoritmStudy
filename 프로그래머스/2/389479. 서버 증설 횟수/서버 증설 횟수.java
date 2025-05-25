import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < players.length; i++) {
            while (!queue.isEmpty() && queue.element() == i) {
                queue.poll();
            }


            int player = players[i];

            if (player / m <= queue.size()) {
                continue;
            }

            int n = player / m - queue.size();
            for (int j = 0; j < n; j++) {
                queue.add(i + k);
                answer++;
            }
        }
        return answer;


    }
}