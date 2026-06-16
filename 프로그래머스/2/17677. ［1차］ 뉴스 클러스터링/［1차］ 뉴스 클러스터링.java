import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        List<String> a = converter(str1);
        List<String> b = converter(str2);


        if (a.isEmpty() && b.isEmpty()) {
            return 65536;
        }

        Map<String, Integer> ca = toMap(a);
        Map<String, Integer> cb = toMap(b);

        int inter = 0;
        int union = 0;

        Set<String> keys = new HashSet<>();

        keys.addAll(ca.keySet());
        keys.addAll(cb.keySet());

        for (String k : keys) {
            int va = ca.getOrDefault(k, 0);
            int vb = cb.getOrDefault(k, 0);

            inter += Math.min(va, vb);
            union += Math.max(va, vb);
        }

        return (int) Math.floor((inter * 65536.0) / union);
    }

    public List<String> converter(String str) {
        List<String> list = new ArrayList<>();
        String target = str.toUpperCase();
        for (int i = 0; i < target.length() - 1; i++) {
            char now = target.charAt(i);
            char next = target.charAt(i + 1);

            if ('A' <= now && now <= 'Z') {
                if ('A' <= next && next <= 'Z') {
                    list.add(String.valueOf(now) + next);
                }
            }
        }

        return list;
    }

    public Map<String, Integer> toMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : list) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return map;
    }
}