import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int playerCount = Integer.parseInt(st.nextToken());
        int roomCount = Integer.parseInt(st.nextToken());

        Player[] players = new Player[playerCount];

        for (int i = 0; i < playerCount; i++) {
            st = new StringTokenizer(br.readLine());
            players[i] = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playerCount; i++) {

            if (Objects.nonNull(players[i])) {
                List<Player> room = new ArrayList<>();
                Player bangJang = players[i];
                int minLevel = bangJang.level - 10;
                int maxLevel = bangJang.level + 10;
                for (int j = i; j < playerCount; j++) {
                    if (room.size() == roomCount) {
                        break;
                    }
                    if (Objects.nonNull(players[j])) {
                        Player player = players[j];
                        if (minLevel <= player.level && maxLevel >= player.level) {
                            room.add(player);
                            players[j] = null;
                        }
                    }
                }
                Collections.sort(room);
                if (room.size() == roomCount) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }

                for (Player p : room) {
                    sb.append(p.level).append(" ").append(p.name).append("\n");
                }
            }
        }

        System.out.println(sb);

    }

}

class Player implements Comparable<Player> {
    int level;
    String name;

    public Player(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int compareTo(Player p) {
        return this.name.compareTo(p.name);
    }
}