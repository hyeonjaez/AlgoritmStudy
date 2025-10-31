import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Integer> dojeon = new HashMap<>();
        Map<Integer , Integer> success = new HashMap<>();
        for(int i = 1; i <= N; i++){
            dojeon.put(i, 0);
            success.put(i, 0);
        }
        
        for(int i : stages){
            for(int j = 1; j < i; j++){
                success.put(j, success.get(j) + 1);
                dojeon.put(j, dojeon.get(j) + 1);
            }
            
            if(1 <= i && i<=N){
                dojeon.put(i, dojeon.get(i) + 1);
            }
            
        }
        
        List<Node> nodeList = new ArrayList<>();
        Node[] nodes = new Node[N];
        for(int i = 1; i <= N; i++){
            if(dojeon.get(i) == 0){
                nodes[i-1] = new Node(i, 0);
                continue;
            }
            
            nodes[i-1] = new Node(i, (double) dojeon.get(i) / success.get(i));
        }
        
        Arrays.sort(nodes);
        
        
        
        return Arrays.stream(nodes).mapToInt(o -> o.number).toArray();
    }
    
    
}

class Node implements Comparable<Node>{
    int number;
    double count;
    Node(int number, double count){
        this.number = number;
        this.count = count;
    }
    
    public int compareTo(Node o){
        return Double.compare(o.count, this.count);
    }
}