import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cards1Queue = arrayToQueue(cards1);
        Queue<String> cards2Queue = arrayToQueue(cards2);

        for (String value : goal) {
            if (Objects.equals(cards1Queue.peek(), value)) {
                cards1Queue.poll();
            } else if (Objects.equals(cards2Queue.peek(), value)) {
                cards2Queue.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
    
    public Queue<String> arrayToQueue(String[] array) {
        return new LinkedList<>(Arrays.asList(array));
    }
}