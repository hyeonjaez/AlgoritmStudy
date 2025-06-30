
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        long sum = 0;

        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            nodeList.add(new Node(number, count));
            sum += count;
        }
        
        Collections.sort(nodeList);

        long result = 0;
        
        long answer = 0;
        for(int i = 0; i < nodeList.size(); i++) {
            result += nodeList.get(i).count;
            
            if((sum + 1)/2 <= result){
                answer = nodeList.get(i).number;
                break;
            }
        }

        System.out.println(answer);


    }


}

class Node implements Comparable<Node> {
    long number;
    long count;

    Node(long number, long count) {
        this.number = number;
        this.count = count;
    }

    public int compareTo(Node o) {
        return (int) (this.number - o.number);
    }

}