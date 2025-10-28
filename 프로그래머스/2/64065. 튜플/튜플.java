import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        String a = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] stArray = a.split("-");
        
        Arrays.sort(stArray, Comparator.comparing(String::length));
        
        List<String> list = new ArrayList<>();
        for(String st : stArray){
            String[] sArray = st.split(",");
            for(String r : sArray){
                if(list.contains(r)){
                
               continue; 
            }
            
            list.add(r);
            }
            
        }
        
        
        return list.stream().mapToInt(Integer::parseInt).toArray();
    }
}