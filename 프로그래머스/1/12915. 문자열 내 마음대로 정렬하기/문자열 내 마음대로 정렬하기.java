import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (String s : strings) {
            pq.add(new Node(s, n));
        }

        int index = 0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            answer[index] = poll.target;
            index++;
        }


        return answer;
    }


}

class Node implements Comparable<Node> {
    String target;
    int n;

    Node(String target, int n) {
        this.target = target;
        this.n = n;
    }

    public int compareTo(Node o) {
        if (target.charAt(n) == o.target.charAt(n)) {
            return target.compareTo(o.target);
        }
        return target.charAt(n) - o.target.charAt(n);
    }
}