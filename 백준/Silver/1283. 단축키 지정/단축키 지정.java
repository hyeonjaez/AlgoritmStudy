import java.io.*;

public class Main {
    static boolean[] map;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new boolean[26];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] sArray = str.split(" ");

            if (firstCheck(sArray)) {
                sb.append("\n");
                continue;
            }

            if (secondCheck(sArray)) {
                sb.append("\n");
                continue;
            }
            sb.append(str).append("\n");


        }

        System.out.println(sb);

    }


    public static boolean firstCheck(String[] array) {
        for (int i = 0; i < array.length; i++) {
            char ch = array[i].charAt(0);

            if ('A' <= ch && ch <= 'Z') {
                ch = (char) ('a' + (ch - 'A'));
            }

            int num = ch - 'a';

            if (!map[num]) {
                map[num] = true;
                makeResult(array, i);
                return true;
            }
        }

        return false;
    }

    public static boolean secondCheck(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String word = array[i];

            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if ('A' <= ch && ch <= 'Z') {
                    ch = (char) ('a' + (ch - 'A'));
                }

                int num = ch - 'a';

                if (!map[num]) {
                    map[num] = true;
                    makeResultTwo(array, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    public static void makeResult(String[] array, int index) {
        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            if (i == index) {
                sb.append("[").append(word.charAt(0)).append("]");
                sb.append(word.substring(1)).append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }

//        System.out.println(sb);
    }

    public static void makeResultTwo(String[] array, int bigIndex, int smallIndex) {
        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            if (i == bigIndex) {
                for (int j = 0; j < word.length(); j++) {
                    char ch = word.charAt(j);
                    if (j == smallIndex) {
                        sb.append("[").append(ch).append("]");
                        continue;
                    }
                    sb.append(ch);
                }
                sb.append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }
    }


}
