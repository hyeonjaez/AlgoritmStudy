import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = "[A-F]?A+F+C+[A-F]?$";

        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            sb.append(br.readLine().matches(str) ? "Infected!" : "Good").append("\n");
        }

        System.out.println(sb);
    }


}