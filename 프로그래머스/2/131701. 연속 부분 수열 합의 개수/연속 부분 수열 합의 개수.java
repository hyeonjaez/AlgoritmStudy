import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int now = 0;
                for(int k = j; k < j + i; k++){
                    now += elements[k % elements.length];
                }
                set.add(now);
            }
        }
        

        return set.size();
    }
}