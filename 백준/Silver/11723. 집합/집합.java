import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] array = new int[21];

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("all") || command.equals("empty")) {
                if (command.equals("empty")) {
                    empty(array);
                } else {
                    allCommand(array);
                }
            } else {
                int target = Integer.parseInt(st.nextToken());

                switch (command) {
                    case "add":
                        addCommand(array, target);
                        break;
                    case "remove":
                        removeCommand(array, target);
                        break;
                    case "toggle":
                        toggleCommand(array, target);
                        break;
                    default:
                        int result = checkCommand(array, target);
                        sb.append(result).append("\n");
                        break;
                }
            }
        }

        System.out.println(sb.toString());


    }

    public static void addCommand(int[] list, int a) {
        if (checkCommand(list, a) == 1) {
            return;
        }
        list[a] = 1;
    }

    public static int checkCommand(int[] list, int a) {
        if (list[a] == 1) {
            return 1;
        }
        return 0;
    }

    public static void removeCommand(int[] list, int a) {
        if (checkCommand(list, a) == 1) {
            list[a] = 0;
        }
    }

    public static void toggleCommand(int[] list, int a) {
        if (checkCommand(list, a) == 1) {
            removeCommand(list, a);
            return;
        }
        addCommand(list, a);
    }

    public static void allCommand(int[] list) {
        for (int i = 0; i < 21; i++) {
            list[i] = 1;
        }
    }

    public static void empty(int[] list) {
        Arrays.fill(list, 0);
    }

}