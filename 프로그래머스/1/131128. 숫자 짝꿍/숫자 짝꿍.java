import java.util.*;
class Solution {
    public String solution(String x, String y) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i =0; i < x.length(); i++){
            if(map.containsKey(x.charAt(i))){
                map.put(x.charAt(i), map.get(x.charAt(i)) + 1);
            }else{
                map.put(x.charAt(i), 1);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < y.length(); i++){
            char now = y.charAt(i);
            
            if(map.containsKey(now) && map.get(now) > 0){
              list.add(now -'0');
                map.put(now, map.get(now) - 1);
            } 
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        
        if(list.isEmpty()){
            return sb.append(-1).toString();
        }else if(list.get(list.size()-1) ==0){
            return sb.append(0).toString();
        }
        
        for(int i = list.size() -1; i >=0; i--){
            sb.append(list.get(i));
        }
        
        String result = sb.toString();
        

        return sb.toString();
    }
}