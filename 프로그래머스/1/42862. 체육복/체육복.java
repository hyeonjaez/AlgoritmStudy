import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] map = new boolean[n + 1];

        for (int i : lost) {
            map[i] = true;
        }

        Arrays.sort(reserve);
        List<Integer> newReserve = new ArrayList<>();

        for (int i : reserve) {
            if (map[i]) {
                map[i] = false;
                answer++;
            } else {
                newReserve.add(i);
            }
        }

        for (int i : newReserve) {
            if (i - 1 > 0) {
                if (map[i - 1]) {
                    map[i - 1] = false;
                    answer++;
                    continue;
                }
            }

            if (i + 1 <= n) {
                if (map[i + 1]) {
                    map[i + 1] = false;
                    answer++;
                }
            }
        }


        return n - lost.length + answer;
    }
}