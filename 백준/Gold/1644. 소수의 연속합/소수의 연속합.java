import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 3; i <= target; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;

        while (true) {
            if (sum >= target) {
                sum -= list.get(start);
                start++;
            } else if (end == list.size()) {
                break;
            } else {
                sum += list.get(end);
                end++;
            }

            if (sum == target) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }


    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}