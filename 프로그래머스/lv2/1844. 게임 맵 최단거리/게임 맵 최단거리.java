import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
                    if(!visited[x][y] && maps[x][y] != 0){
                        queue.add(new int[] {x, y});
                        maps[x][y] += maps[now[0]][now[1]];
                        visited[x][y] = true;
                    }
                }
            }
        }
        
        int answer = maps[maps.length-1][maps[0].length-1]; 
        if(answer == 1) {
            answer = -1;
        }
        return answer;
    }
}