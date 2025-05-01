import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] successCount = new int[N + 1];

        int[] dojeonCount = new int[N + 1];
        Node[] result = new Node[N];

        for (int s : stages) {
            for (int i = 1; i < s; i++) {
                successCount[i]++;
                dojeonCount[i]++;
            }

            if (s <= N) {
                dojeonCount[s]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if(dojeonCount[i + 1] == 0){
                result[i] = new Node(i + 1, 0);
                continue;
            }

            result[i] = new Node(i + 1, (double) dojeonCount[i + 1] / successCount[i + 1]);
        }

        Arrays.sort(result);


        return Arrays.stream(result).mapToInt(o -> o.index).toArray();
    }
}

class Node implements Comparable<Node> {
    int index;
    double count;

    Node(int index, double count) {
        this.index = index;
        this.count = count;
    }

    public int compareTo(Node o) {
        return  Double.compare(o.count, this.count);
    }
}