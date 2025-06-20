import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        boolean[] isSkip = new boolean[27];

        for (char c : skip.toCharArray()) {
            isSkip[c - 'a'] = true;
        }

        for (char c : s.toCharArray()) {
            sb.append(jumpIndex(c , index, isSkip));
        }


        return sb.toString();
    }

    public char jumpIndex(char target, int index, boolean[] isSkip) {
        for (int i = 0; i < index; i++) {
            target += 1;

            if (target > 'z') {
                target -= 26;
            }

            while (isSkip[target - 'a']) {
                target += 1;

                if (target > 'z') {
                    target -= 26;
                }
            }

        }

        return target;
    }
}