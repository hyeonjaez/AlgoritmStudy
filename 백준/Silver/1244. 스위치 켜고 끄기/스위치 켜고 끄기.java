import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        int[] array = new int[number + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= number; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int human = Integer.parseInt(br.readLine());

        for (int i = 0; i < human; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                male(array, b);
            } else {
                female(array, b);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < array.length; i++) {

            sb.append(array[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());


    }


    public static void male(int[] array, int number) {
        int switchNumber = 0;
        for (int i = number; i < array.length; i += number) {

            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }

            switchNumber++;
        }
    }

    public static void female(int[] array, int number) {
        if (array[number] == 0) {
            array[number] = 1;
        } else {
            array[number] = 0;
        }

        int min = Math.min(number, array.length - number) - 1;

        for (int i = 1; i <= min; i++) {
            if (array[number - i] == array[number + i]) {
                if (array[number - i] == 0) {
                    array[number - i] = 1;
                } else {
                    array[number - i] = 0;
                }


                if (array[number + i] == 0) {
                    array[number + i] = 1;
                } else {
                    array[number + i] = 0;
                }
            } else {
                return;
            }
        }
    }

}