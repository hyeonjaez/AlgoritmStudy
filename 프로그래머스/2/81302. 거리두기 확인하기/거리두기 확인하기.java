import java.util.*;
class Solution {
     int[] dx = {-1, 1, 0, 0, -2, 2, 0, 0, 1, 1, -1, -1};
     int[] dy = {0, 0, -1, 1, 0, 0, -2, 2, 1, -1, 1, -1};
    public int[] solution(String[][] places) {
        List<Integer> result = new ArrayList<>();

        for (String[] place : places) {
            String[][] map = new String[5][5];
            Queue<int[]> queue = new LinkedList<>();
            int index = 0;
            for (String p : place) {
                String[] split = p.split("");

                for (int i = 0; i < split.length; i++) {
                    map[index][i] = split[i];

                    if (map[index][i].equals("P")) {
                        queue.add(new int[]{index, i});
                    }
                }


                index++;
            }

            if (d(map, queue)) {
                result.add(1);
            } else {
                result.add(0);
            }

        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public boolean d(String[][] map, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int nowX = cur[0];
            int nowY = cur[1];
            for (int i = 0; i < dx.length; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
                    if (map[x][y].equals("P")) {
                        if (nowX != x && nowY != y) {

                            if (!(map[nowX][y].equals("X") && map[x][nowY].equals("X"))) {

                                return false;
                            }
                        } else {
                            if (nowX == x) {
                                if (!map[nowX][Math.max(nowY, y) - 1].equals("X")) {
                                    return false;
                                }
                            } else if (nowY == y) {
                                if (!map[Math.max(nowX, x) - 1][nowY].equals("X")) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}