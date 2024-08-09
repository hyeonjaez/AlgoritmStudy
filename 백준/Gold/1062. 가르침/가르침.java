import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int k;
    static final String START = "anta";
    static final String END = "tica";
    static String[] word;
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if (k < 5) {
                System.out.println(0);
                return;
            }


            k -= 5;
            word = new String[n];
            visited = new boolean[26];
            answer = Integer.MIN_VALUE;

            visited[0] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;


            for (int i = 0; i < n; i++) {
                String line = br.readLine().trim();
                String replace = line.replace(START, "").replace(END, "");
                word[i] = replace;
            }
            backtracking(0,0);
            System.out.println(answer);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void backtracking(int start, int depth) {
        if (depth == k) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean read = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if (!visited[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read) {
                    count++;
                }
            }

            answer = Math.max(answer, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, depth + 1);
                visited[i] = false;
            }
        }
    }

}