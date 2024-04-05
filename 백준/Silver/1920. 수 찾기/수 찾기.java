import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] array;
    static int[] find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        array = new int[N];
//        array = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .sorted()
//                .toArray();
//
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        find = new int[M];
//        find = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            if (binarySearch(find[i], 0, array.length - 1)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }


    }


    public static boolean binarySearch(int key, int start, int end) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (key == array[mid]) {
                return true;
            } else if (key > array[mid]) {
                start = mid + 1;
            } else if (key < array[mid]) {
                end = mid - 1;
            }
        }
        return false;
    }
}