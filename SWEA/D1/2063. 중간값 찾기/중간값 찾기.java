import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < number; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            list.sort(Integer::compareTo);

            int mid = number /= 2;

            System.out.println(list.get(mid));
        }
    }
}