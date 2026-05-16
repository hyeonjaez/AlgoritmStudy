import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        Queue<Integer> remain = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Node(progresses[i], speeds[i]));
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowResult = get(now.pro, now.sped);
            int count = 1;
            while (!queue.isEmpty()) {
                Node next = queue.peek();
                int nextResult = get(next.pro, next.sped);

                if (nowResult >= nextResult) {
                    queue.poll();
                    count++;
                } else {
                    break;
                }
            }

            answer.add(count);

        }


        return answer.stream().mapToInt(value -> value).toArray();
    }

    public int get(int pro, int sped) {
        if ((100 - pro) % sped == 0) {
            return (100 - pro) / sped;
        } else {
            return (100 - pro) / sped + 1;
        }
    }


}

class Node {
    int pro;
    int sped;

    Node(int pro, int sped) {
        this.pro = pro;
        this.sped = sped;
    }
}