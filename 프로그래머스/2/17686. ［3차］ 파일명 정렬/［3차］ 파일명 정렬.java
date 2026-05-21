import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] result = new String[files.length];
        Node[] nodeArray = new Node[files.length];

        for (int i = 0; i < files.length; i++) {
            nodeArray[i] = new Node(files[i]);
        }

        Arrays.sort(nodeArray);

        for (int i = 0; i < files.length; i++) {
            result[i] = nodeArray[i].name;
        }

        return result;
    }


}

class Node implements Comparable<Node> {
    String name;
    String head;
    int number;

    Node(String name) {
        this.name = name;
        parse();
    }

    private void parse() {
        int i = 0;

        while (i < name.length() && !Character.isDigit(name.charAt(i))) {

            i++;

        }

        head = name.substring(0, i).toUpperCase();

        int numberStart = i;

        while (i < name.length() && Character.isDigit(name.charAt(i))) {

            i++;

        }

        number = Integer.parseInt(name.substring(numberStart, i));
    }

    public int compareTo(Node o) {
        int compare = this.head.compareTo(o.head);

        if (compare != 0) {
            return compare;
        }
        return this.number - o.number;
    }
}