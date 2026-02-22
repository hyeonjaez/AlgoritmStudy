import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i <n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int count = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++){
            int now = Integer.parseInt(st.nextToken());

            if(set.contains(now)){
                sb.append(1);
            }else{
                sb.append(0);
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }


}

