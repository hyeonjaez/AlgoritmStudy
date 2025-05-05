import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Boolean> exit = new HashMap<>();

        for (String str : id_list) {
            count.put(str, 0);
            exit.put(str, false);
            reportMap.put(str, new HashSet<>());
        }

        for (String str : report) {
            String[] s = str.split(" ");
            String re = s[0];
            String target = s[1];

            if (reportMap.get(re).add(target)) {
                count.put(target, count.get(target) + 1);
            }

        }


        Set<String> suspended = new HashSet<>();

        for (String id : id_list) {
            if (count.get(id) >= k) {
                suspended.add(id);
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++){
            String user = id_list[i];
            
            int mail = 0;
            
            for(String target : reportMap.get(user)){
                if(suspended.contains(target)){
                    mail++;
                }
            }
            answer[i] = mail;
        }


        return answer;
    }
}