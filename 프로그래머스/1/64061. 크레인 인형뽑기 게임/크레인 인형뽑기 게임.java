import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Queue<Integer>[] queues = new Queue[board.length + 1];
        Stack<Integer> result = new Stack<>();

        for (int i = 1; i <= board.length; i++) {
            queues[i] = new LinkedList<>();
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int now = board[i][j];

                if (now > 0) {
                    queues[j + 1].add(board[i][j]);
                }
            }
        }
        for (int i : moves) {
            if (!queues[i].isEmpty()) {
                int poll = queues[i].poll();
                if (!result.isEmpty()) {
                    if (result.peek() == poll) {
                        result.pop();
                        answer += 2;
                        continue;
                    }
                }

                result.push(poll);


            }
        }


        return answer;
    }
}