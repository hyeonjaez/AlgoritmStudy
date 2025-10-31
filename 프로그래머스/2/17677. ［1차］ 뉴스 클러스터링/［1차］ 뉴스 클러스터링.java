import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> a = split(converter(str1));
        List<String> b = split(converter(str2));
        
        
        if(a.isEmpty() && b.isEmpty()){
            return 65536;
        }
        
        Map<String, Integer> ca = countMap(a);
        Map<String, Integer> cb = countMap(b);
        
        int inter = 0;
        int union = 0;
        
        Set<String> keys = new HashSet<>();
        
        keys.addAll(ca.keySet());
        keys.addAll(cb.keySet());
        
        for(String k : keys){
            int va = ca.getOrDefault(k, 0);
            int vb = cb.getOrDefault(k, 0);
            
            inter += Math.min(va, vb);
            union += Math.max(va, vb);
        }
        
        
        return (int) Math.floor((inter * 65536.0) / union);
        
    }
    
    public String converter(String target){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < target.length(); i++){
            char ch = target.charAt(i);
            if(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')){
                sb.append(ch);
            }else{
                sb.append(" ");
            }
        }
        return sb.toString();
        
    }
    
    public List<String> split(String target){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < target.length() - 1; i++) {
            if(target.charAt(i) != ' ' && target.charAt(i + 1) != ' '){
                list.add(new StringBuilder().append(target.charAt(i)). append(target.charAt(i + 1)).toString().toLowerCase());
            }
        }
        return list;
    }
    
    public Map<String, Integer> countMap(List<String> list){
        Map<String, Integer> map = new HashMap<>();
        
        for(String str : list){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return map;
    }
    
    
}