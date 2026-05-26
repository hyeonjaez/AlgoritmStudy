import java.util.*;
class Solution {
    public int solution(String s) {
        int min = s.length();

        for (int slice = 1; slice <= s.length() / 2; slice++) {
            StringBuilder result = new StringBuilder();

            String before = s.substring(0, slice);
            int count = 1;
            for (int j = slice; j < s.length(); j += slice) {
                String now = s.substring(j, Math.min(j + slice, s.length()));

                if (now.equals(before)) {
                    count++;
                } else {
                    if (count > 1) {
                        result.append(count);
                    }
                    result.append(before);
                    before = now;
                    count = 1;
                }
            }

            if (count > 1) {
                result.append(count);
            }
            result.append(before);
            
            min = Math.min(min, result.length());
        }


        return min;
    }
}