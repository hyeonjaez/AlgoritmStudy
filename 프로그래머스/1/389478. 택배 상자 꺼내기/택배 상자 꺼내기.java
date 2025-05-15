import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        List<Stack<Integer>> stackList = new ArrayList<>();

        for (int i = 0; i < w; i++) {
            stackList.add(new Stack<>());
        }

        for (int i = 1; i <= n; i++) {
            int row = (i - 1) / w;
            int colInRow = (i - 1) % w;
            int index = (row % 2 == 0) ? colInRow : (w - 1 - colInRow);

            stackList.get(index).push(i);
        }

        int row = (num - 1) / w;
        int colInRow = (num - 1) % w;
        int targetIndex = (row % 2 == 0) ? colInRow : (w - 1 - colInRow);

        Stack<Integer> stack = stackList.get(targetIndex);

        while (!stack.isEmpty()) {
            int number = stack.pop();
            System.out.println(number);
            answer++;
            if (number == num) {
                break;
            }
        }

        return answer;
    }
}