import java.io.*;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer stringTokenizer;
            int testCount = Integer.parseInt(bufferedReader.readLine());

            for (int test = 1; test <= testCount; test++) {
                int arrayLength = Integer.parseInt(bufferedReader.readLine());
                int[][] array = new int[arrayLength][arrayLength];

                for (int i = 0; i < arrayLength; i++) {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                    for (int j = 0; j < arrayLength; j++) {
                        array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                    }
                }

                int[][] array90 = turnArray_90(array);
                int[][] array180 = turnArray_90(array90);
                int[][] array270 = turnArray_90(array180);

                sb.append("#").append(test).append("\n");

                for (int i = 0; i < arrayLength; i++) {
                    for (int j = 0; j < arrayLength; j++) {
                        sb.append(array90[i][j]);

                    }
                    sb.append(" ");

                    for (int j = 0; j < arrayLength; j++) {
                        sb.append(array180[i][j]);

                    }
                    sb.append(" ");

                    for (int j = 0; j < arrayLength; j++) {
                        sb.append(array270[i][j]);

                    }
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());

        }
    }

    public static int[][] turnArray_90(int[][] array) {
        int[][] result = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                result[i][j] = array[array.length - 1 - j][i];
            }
        }

        return result;
    }
}