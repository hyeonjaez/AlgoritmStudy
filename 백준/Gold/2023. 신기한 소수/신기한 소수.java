import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();

            back(2, 1);
            back(3, 1);
            back(5, 1);
            back(7, 1);
            System.out.println(sb);
        }

    }

    public static void back(int number, int depth) {
        if (depth == N) {
            if (checkPrime(number)) {
                sb.append(number).append("\n");
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (checkPrime(number * 10 + i)) {
                back(number * 10 + i, depth + 1);
            }
        }
    }

    public static boolean checkPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


}
