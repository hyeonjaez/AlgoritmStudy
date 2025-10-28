import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i <s.length(); i++){
            char ch = s.charAt(i);
            if('0' <= ch && ch <= '9'){
                result.append(ch);
                continue;
            }
            sb.append(ch);
            
            if(map.containsKey(sb.toString())){
                result.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }
            
            
        }
        
        
        
        return Integer.parseInt(result.toString());
    }
}