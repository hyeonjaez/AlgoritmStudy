import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static char[] chars;
    static char[] selected;
    static StringBuilder sb;
    static final int MIN_VOWEL = 1;
    static final int MIN_CONSONANT = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        chars = new char[n];
        selected = new char[m];
        String str = br.readLine().replaceAll(" ", "");
        for (int i = 0; i < n; i++) {
            chars[i] = str.charAt(i);
        }

        Arrays.sort(chars);

        back(0, 0);
        System.out.println(sb);
    }

    public static void back(int start, int depth) {
        if (depth == m) {
            if (check(selected)) {
                for (char c : selected) {
                    sb.append(c);
                }

                sb.append("\n");
            }

            return;
        }

        for (int i = start; i < n; i++) {
            selected[depth] = chars[i];
            back(i + 1, depth + 1);
        }
    }

    public static boolean check(char[] select) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (char c : select) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= MIN_VOWEL && consonantCount >= MIN_CONSONANT;
    }
}