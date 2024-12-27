import java.io.*;

public class Main {
    static int[] a = {1, 3};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }


}