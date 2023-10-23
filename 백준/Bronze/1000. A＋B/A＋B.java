import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        int sum = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).sum();

        System.out.println(sum);
    }
}
