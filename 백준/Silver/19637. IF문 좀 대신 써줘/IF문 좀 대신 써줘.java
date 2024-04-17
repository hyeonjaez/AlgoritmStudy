import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Character> list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Character(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (list.get(mid).getPower() < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            bw.write(list.get(left).getPowerName() + "\n");
        }
        bw.flush();
    }
}

class Character {
    private final String powerName;
    private final int power;

    public Character(String powerName, int power) {
        this.powerName = powerName;
        this.power = power;
    }

    public String getPowerName() {
        return powerName;
    }

    public int getPower() {
        return power;
    }
}