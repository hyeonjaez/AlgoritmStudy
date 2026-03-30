import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] array;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int lenght = n;

        while (lenght != 0) {
            lenght /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];

        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < m + j; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a == 1) {
                change(leftNodeStartIndex + s, e);
            } else {
                s = s + leftNodeStartIndex;
                e = e + leftNodeStartIndex;
                System.out.println(get(s, (int) e));
            }

        }


    }

    public static long get(int start, int end) {
        long answer = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                answer += tree[start];
                start++;
            }
            if (end % 2 == 0) {
                answer += tree[end];
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return answer;
    }


    public static void change(int index, long value) {
        long diff = value - tree[index];

        while (index > 0) {
            tree[index] = tree[index] + diff;

            index /= 2;
        }
    }

    public static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }


}