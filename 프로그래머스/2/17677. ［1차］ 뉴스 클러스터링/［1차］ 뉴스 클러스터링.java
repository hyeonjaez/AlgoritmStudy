import java.util.*;
class Solution {
    public int solution(String str1, String str2) {

        List<String> split1 = splits(converter(str1));
        List<String> split2 = splits(converter(str2));

        int gyo = 0;

        if (split1.isEmpty() && split2.isEmpty()) {
            return 65536;
        }

        List<String> union = new ArrayList<>();
        List<String> inter = new ArrayList<>();

        for (String str : split1) {
            if (split2.remove(str)) {
                inter.add(str);
            }
            union.add(str);
        }

        union.addAll(split2);

        
        return (int) ((double) inter.size() / (double) union.size() * 65536);
    }


    public String converter(String target) {
        return target.replaceAll("[^a-zA-Z]", " ");
    }

    public List<String> splits(String target) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < target.length() - 1; i++) {
            int next = i + 1;

            if (target.charAt(i) != ' ' && target.charAt(next) != ' ') {
                list.add((String.valueOf(target.charAt(i)) + target.charAt(next)).toLowerCase());
            }
        }
        return list;
    }

    public int getGyo(List<String> first, List<String> second) {
        int result = 0;
        for (String s : second) {
            if (first.contains(s)) {
                result++;
            }
        }
        return result;
    }
}