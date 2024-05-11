import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int amounts = amount[i] * 100;

            while (amounts > 0 && !sellerName.equals("-")) {
                total.put(sellerName, total.getOrDefault(sellerName, 0) + amounts - amounts / 10);
                sellerName = map.get(sellerName);
                amounts /= 10;
            }
        }

        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}