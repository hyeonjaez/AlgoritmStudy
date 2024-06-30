import java.io.*;
import java.util.*;


class Solution
{
	public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println(judgeGame(A, B));
        }
    }

    public static String judgeGame(int A, int B) {
        if (A == B) {
            return null;
        }

        if ((A == 1 && B == 3) || (A == 2 && B == 1) || (A == 3 && B == 2)) {
            return "A";
        } else {
            return "B";
        }
    }
}