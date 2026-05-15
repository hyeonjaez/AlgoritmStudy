import java.util.*;
class Solution {
        public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparing(o -> o[0]));

        PriorityQueue<Node> queue = new PriorityQueue<>();
        int count = 0;
        int index = 0;
        int end = 0;
        int total = 0;
        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= end) {
                queue.add(new Node(jobs[index][0], jobs[index][1], index));
                index++;
            }

            if (queue.isEmpty()) {
                end = jobs[index][0];
            } else {
                Node now = queue.poll();
                total += now.requestTime + end - now.time;
                end += now.requestTime;
                count++;

            }
        }
        return total / jobs.length;
    }


}

class Node implements Comparable<Node> {
    int time;
    int requestTime;
    int number;

    Node(int time, int requestTime, int number) {
        this.time = time;
        this.requestTime = requestTime;
        this.number = number;
    }

    public int compareTo(Node o) {
        if (this.requestTime == o.requestTime) {
            if (this.time == o.time) {
                return this.number - o.number;
            }
            return this.time - o.time;
        }
        return this.requestTime - o.requestTime;
    }
}
