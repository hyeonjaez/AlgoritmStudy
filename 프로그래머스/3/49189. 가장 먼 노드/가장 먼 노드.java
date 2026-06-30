import java.util.*;
class Solution {
    int[] lengthArray;
    List<Integer>[] array;
    int max = Integer.MIN_VALUE;

    public int solution(int n, int[][] edge) {
        array = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = new ArrayList<>();
        }

        lengthArray = new int[n + 1];

        Arrays.fill(lengthArray, Integer.MAX_VALUE);


        for (int[] e : edge) {
            array[e[0]].add(e[1]);
            array[e[1]].add(e[0]);
        }

        bfs();
        
        int result = 0;
        for (int i = 2; i <= n; i++) {
            if (lengthArray[i] == max) {
                result++;
            }
        }


        return result;
    }

    public void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[1] > lengthArray[now[0]]) {
                continue;
            }

            lengthArray[now[0]] = now[1];

            for (int i : array[now[0]]) {
                if (lengthArray[i] > now[1] + 1) {
                    lengthArray[i] = now[1] + 1;
                    queue.add(new int[]{i, now[1] + 1});

                    max = Math.max(max, now[1] + 1);
                }
            }
        }
    }
}