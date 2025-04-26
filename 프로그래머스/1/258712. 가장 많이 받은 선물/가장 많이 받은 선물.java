import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 선물을 더 준 사람한테 하나 더 줌
        // 두 사람이 선물을 주고 받은 기록이 없거나 주고 받은 수가 같으면 선물 지수가 더 큰 사람이 하나 더 받음
        // 하지만 선물 지수가 같으면 없음 
        
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        int[][] gift = new int[friends.length][friends.length];
        int[] giftCount = new int[friends.length];

        for (int i = 0; i < gifts.length; i++) {
            String[] split = gifts[i].split(" ");
            gift[map.get(split[0])][map.get(split[1])]++;
            giftCount[map.get(split[0])]++;
            giftCount[map.get(split[1])]--;
        }
        int answer = 0;
        for (int i = 0; i < friends.length; i++) {
            int number = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }

                if (gift[i][j] > gift[j][i] || (gift[i][j] == gift[j][i] && giftCount[i] > giftCount[j])) {
                    number++;
                }
            }

            answer = Math.max(answer, number);
        }



        
        return answer;
    }
}