import java.io.*;
import java.util.Arrays;

public class Main {
    static boolean isValid;
    static int finishCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            int[] str = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            isValid = false;
            finishCount = 0;

            Arrays.sort(str);

            int a = str[0];
            int b = str[1];
            int max = str[2];
            setIsFinish(a);
            setIsFinish(b);
            setIsFinish(max);

            if (isValid) {
                if (finishCount == 3) {
                    break;
                }
                sb.append("Invalid").append("\n");
                continue;
            }

            if (validTriangle(a, b, max)) {
                sb.append("Invalid").append("\n");
                continue;
            }

            if (a == b || b == max) {
                if (a == max) {
                    sb.append("Equilateral").append("\n");
                } else {
                    sb.append("Isosceles").append("\n");
                }
            } else {
                sb.append("Scalene").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void setIsFinish(int a) {

        if (a == 0) {
            isValid = true;
            finishCount++;
        }
    }

    public static boolean validTriangle(int a, int b, int max) {
        return max >= a + b;
    }
}