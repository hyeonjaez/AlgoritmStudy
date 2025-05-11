import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Map<Node, String> map = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int number = 1;
        for (String file : files) {
            parse(file, map, queue, number);
            number++;
        }
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node n = queue.poll();

            list.add(map.get(n));
        }


        return list.stream().map(o -> o).toArray(String[]::new);
    }

    public void parse(String str, Map<Node, String> map, PriorityQueue<Node> queue, int count) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '.') {
                break;
            }

            if (ch >= '0' && ch <= '9') {
                number.append(ch);
            } else if (number.length() <= 0) {
                head.append(ch);
            } else {
                break;
            }

        }

        Node node = new Node(head.toString(), Integer.parseInt(number.toString()), count);
        map.put(node, str);
        queue.add(node);
    }
}

class Node implements Comparable<Node> {
    String head;
    int number;
    int count;

    Node(String head, int number, int count) {
        this.head = head;
        this.number = number;
        this.count = count;
    }

    public int compareTo(Node o) {
        String headUpper = head.toUpperCase();
        String tarGetUpper = o.head.toUpperCase();

        int headCompare = headUpper.compareTo(tarGetUpper);

        if (headCompare != 0) {
            return headCompare;
        }

        int numberCompare = Integer.compare(number, o.number);

        if (numberCompare != 0) {
            return numberCompare;
        }

        return Integer.compare(count, o.count);
    }

}