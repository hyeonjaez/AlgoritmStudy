import java.io.*;
import java.util.*;

public class Main {
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Human> humans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            humans.add(new Human(i, weight, height));
        }

        for (int i = 0; i < humans.size(); i++) {
            for (int j = 0; j < humans.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (isWin(humans.get(i), humans.get(j))) {
                    humans.get(i).plusCount();
                }

            }
        }

        for (Human human : humans) {
            sb.append(human.count).append(" ");
        }

        System.out.println(sb.toString());


    }

    public static boolean isWin(Human thisHuman, Human targetHuman) {
        return thisHuman.height < targetHuman.height && thisHuman.weight < targetHuman.weight;
    }

}

class Human {
    int index;
    int weight;
    int height;
    int count;

    public Human(int index, int weight, int height) {
        this.index = index;
        this.weight = weight;
        this.height = height;
        this.count = 1;
    }

    public void plusCount() {
        this.count++;
    }


}