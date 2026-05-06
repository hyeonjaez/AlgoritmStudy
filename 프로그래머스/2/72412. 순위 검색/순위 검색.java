import java.util.*;
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];


        for (String in : info) {
            String[] array = in.split(" ");
            int score = Integer.parseInt(array[4]);
            makeKey(0, "", array, score);
        }
        
        for (List<Integer> scores : map.values()) {

    Collections.sort(scores);

}

        for (int i = 0; i < query.length; i++) {
            String now = query[i].replace(" and ", " ");

            String[] array = now.split(" ");

            String key = array[0] + array[1] + array[2] + array[3];
            int score = Integer.parseInt(array[4]);
            
            List<Integer> scores = map.getOrDefault(key, new ArrayList<>());
            int index = find(scores, score);
            result[i] = scores.size() - index;
        }

        return result;
    }

    private void makeKey(int depth, String key, String[] arr, int score) {
        if (depth == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        makeKey(depth + 1, key + arr[depth], arr, score);
        makeKey(depth + 1, key + "-", arr, score);

    }

    public int find(List<Integer> list, int score) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}