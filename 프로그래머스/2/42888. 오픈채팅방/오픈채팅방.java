import java.util.*;
class Solution {
    public static final String ENTER = "님이 들어왔습니다.";
    public static final String OUT = "님이 나갔습니다.";


    public String[] solution(String[] record) {
        String[] answer = {};

        Queue<Node> queue = new LinkedList<>();
        Map<String, String> map = new HashMap<>();

        for (String records : record) {
            String[] split = records.split(" ");
            String command = split[0];
            String id = split[1];
            String name;
            if (!command.equals("Leave")) {
                name = split[2];

                map.put(id, name);

            }

            if (command.equals("Enter")) {
                queue.add(new Node(id, ENTER));
            } else if (command.equals("Leave")) {
                queue.add(new Node(id, OUT));
            }
        }

        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            list.add(map.get(poll.id) + poll.message);
        }


        return list.stream().toArray(String[]::new);
    }
}

class Node {
    String id;
    String message;

    Node(String id, String message) {
        this.id = id;
        this.message = message;
    }
}