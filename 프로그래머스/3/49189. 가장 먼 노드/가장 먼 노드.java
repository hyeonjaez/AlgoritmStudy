import java.io.*;
import java.util.*;

class Solution {
     List<Integer>[] map;
     boolean[] visited;
     int maxDepth;
     int[] distance;
    
    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        map = new List[n + 1];

        for(int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        distance = new int[n + 1];

        for (int[] a : edge) {
            map[a[0]].add(a[1]);
            map[a[1]].add(a[0]);
        }

        maxDepth = 0;
        bfs(1);
        int count = 0;
        for (int a : distance) {
            if (a == maxDepth) {
                count++;
            }
        }

        return count;
    }

    public void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            maxDepth = Math.max(maxDepth, now[1]);

            for (int a : map[now[0]]) {
                if (!visited[a]) {
                    visited[a] = true;
                    distance[a] = now[1] + 1;
                    queue.add(new int[]{a, now[1] + 1});
                }
            }
        }
    }
}