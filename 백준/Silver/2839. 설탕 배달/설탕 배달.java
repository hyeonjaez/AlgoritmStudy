import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int basket = 0;

            while (N > 0) {
                if (N % 5 == 0) {
                    basket += N / 5;
                    break;
                } else {
                    N -= 3;
                    basket++;
                }
                if (N < 0) {
                    basket = -1;
                }
            }
            System.out.println(basket);
        }

    }
}