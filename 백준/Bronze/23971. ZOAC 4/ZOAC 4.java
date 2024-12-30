import java.io.*;
import java.util.*;

public class Main {
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int xCount = Integer.parseInt(st.nextToken()) + 1;
        int yCount = Integer.parseInt(st.nextToken()) + 1;

        int xNum = (int) Math.ceil((double) x / xCount);
        int yNum = (int) Math.ceil((double) y / yCount);

        System.out.println(xNum * yNum);

    }

}
