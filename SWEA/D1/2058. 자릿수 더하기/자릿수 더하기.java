import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int target = Integer.parseInt(bufferedReader.readLine());

            int result = 0;
            while (target != 0) {
                result += target % 10;

                target = target / 10;
            }

            System.out.println(result);
        }
    }
}