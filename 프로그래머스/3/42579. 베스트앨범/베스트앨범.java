import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, PriorityQueue<Node>> mapList = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String str = genres[i];
            int a = plays[i];

            map.put(str, map.getOrDefault(str, 0) + a);

            if (mapList.containsKey(str)) {
                PriorityQueue<Node> node = mapList.get(str);
                node.add(new Node(i, a));
                mapList.put(str, node);
            } else {
                PriorityQueue<Node> node = new PriorityQueue<>();
                node.add(new Node(i, a));
                mapList.put(str, node);
            }

        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue()); 

        List<String> collect = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            collect.add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        for (String s : collect) {
            PriorityQueue<Node> nodes = mapList.get(s);
            int count = 0;
            while (!nodes.isEmpty()) {
                if (count == 2) {
                    break;
                }
                result.add(nodes.poll().number);
                count++;
            }

        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}

class Node implements Comparable<Node> {
    int number;
    int count;

    Node(int number, int count) {
        this.number = number;
        this.count = count;
    }

    public int compareTo(Node o) {
        if (this.count == o.count) {
            return this.number - o.number;
        }
        return o.count - this.count;
    }
}


