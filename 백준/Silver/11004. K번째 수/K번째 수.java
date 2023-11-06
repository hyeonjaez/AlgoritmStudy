import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        System.out.println(array[K - 1]);
//        quickSort(array);
//        System.out.println(array[K - 1]);
    }

    public static void quickSort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    private static void quick(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int low = start + 1;
        int high = end;


        while (low <= high) {
            while (low <= end && arr[low] <= arr[pivot]) {
                low++;
            }
            while (high > start && arr[high] >= arr[pivot]) {
                high--;
            }
            if (low > high) {
                swap(arr, high, pivot);
            } else {
                swap(arr, low, high);
            }
        }

        quick(arr, start, high - 1);
        quick(arr, high + 1, end);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}