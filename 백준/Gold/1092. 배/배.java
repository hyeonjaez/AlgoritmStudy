import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> array = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        List<Integer> boxArray = new ArrayList<>();
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxArray.add(Integer.parseInt(st.nextToken()));
            pqueue.add(boxArray.get(i));
        }

        array.sort(Collections.reverseOrder());
        boxArray.sort(Collections.reverseOrder());

        if (boxArray.get(0) > array.get(0)) {
            System.out.println(-1);
            return;
        }

        int result = 0;
        

        while (!boxArray.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < n; ) {
                if (idx == boxArray.size()) {
                    break;
                } else if (array.get(i) >= boxArray.get(idx)) {
                    boxArray.remove(idx);
                    i++;
                } else {
                    idx++;
                }
            }

            result++;
        }

        System.out.println(result);


    }


}

