import java.util.*;
class Solution {
     public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        for (String re : record) {
            String[] split = re.split(" ");
            String command = split[0];
            String id;
            String name;

            switch (command) {
                case "Enter":
                    id = split[1];
                    name = split[2];
                    map.put(id, name);
                    queue.add(new Node(id, "님이 들어왔습니다."));
                    break;
                case "Leave":
                    id = split[1];
                    if (map.containsKey(id)) {
                        queue.add(new Node(id, "님이 나갔습니다."));
                    }

                    break;
                case "Change":
                    id = split[1];
                    name = split[2];
                    map.put(id, name);
                    break;
                default:
                    break;
            }
        }
        String[] answer = new String[queue.size()];
        int index = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            answer[index] = map.get(poll.id) + poll.command;
            index++;
        }


        return answer;
    }


}

class Node {
    String id;
    String command;

    Node(String id, String command) {
        this.id = id;
        this.command = command;
    }
}