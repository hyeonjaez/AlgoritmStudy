import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int limitCount;
    static int[][] array;
    static List<House> houseList;
    static List<Chicken> chickenList;
    static int chickenCount;
    static Chicken[] nowChicken;
    static int min;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            limitCount = Integer.parseInt(st.nextToken());

            houseList = new ArrayList<>();
            chickenList = new ArrayList<>();

            array = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                    if (array[i][j] == 1) {
                        houseList.add(new House(i, j));
                    }

                    if (array[i][j] == 2) {
                        chickenList.add(new Chicken(i, j));
                    }
                }
            }
            nowChicken = new Chicken[limitCount];
            min = Integer.MAX_VALUE;
            chickenCount = chickenList.size();
            backTracking(0, 0);

            System.out.println(min);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void backTracking(int start, int depth) {
        if (depth == limitCount) {
            int sum = 0;
            for (House house : houseList) {

                int nowMin=  Integer.MAX_VALUE;
                for (Chicken chicken : nowChicken) {
                    int x = Math.abs(chicken.x - house.x);
                    int y = Math.abs(chicken.y - house.y);
                    nowMin = Math.min(x+y, nowMin);
                }
                sum += nowMin;
            }
            min = Math.min(sum, min);
            return;
        }

        for (int i = start; i < chickenCount; i++) {
            nowChicken[depth] = chickenList.get(i);
            backTracking(i + 1, depth + 1);
        }
    }


}

class House {
    int x;
    int y;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Chicken {
    int x;
    int y;

    public Chicken(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
