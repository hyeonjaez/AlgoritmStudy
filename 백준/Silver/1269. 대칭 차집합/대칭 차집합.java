import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aCount = Integer.parseInt(st.nextToken());
        int bCount = Integer.parseInt(st.nextToken());

        TreeSet<Integer> aSet = new TreeSet<>();
        TreeSet<Integer> bSet = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aCount; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bCount; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }
        int result = 0;
        for (int i : bSet) {
            if (!aSet.contains(i)) {
                result++;
            }
        }

        for (int i : aSet) {
            if (!bSet.contains(i)) {
                result++;
            }
        }
        

        System.out.println(result);


    }

}