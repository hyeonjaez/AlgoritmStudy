import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }

        int index = splitIndex(p);


        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        if (isCorrect(u)) {
            return u + solution(v);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("(");
        sb.append(solution(v));
        sb.append(")");


        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }

        return sb.toString();
    }
    
    public int splitIndex(String p) {
        int count = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                return i;
            }


        }

        return p.length() - 1;
    }

    public boolean isCorrect(String p) {
        int count = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}