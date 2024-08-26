import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		int[] array = new int[26];
		for (int i = 0; i < count; i++) {
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				int idx = str.charAt(j) - 'A';
				array[idx] += (int) Math.pow(10, (str.length() - 1) - j);
			}
		}
		Arrays.sort(array);

		int sum = 0;
		int number = 9;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == 0) {
				break;
			}

			sum += (array[i] * number);
			number--;
		}
		System.out.println(sum);
	}
}
