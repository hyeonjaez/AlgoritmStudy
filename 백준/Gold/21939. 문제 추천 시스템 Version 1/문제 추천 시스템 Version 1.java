import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        TreeSet<Problem> problems = new TreeSet<>(getComparator());


        Map<Integer, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            map.put(number, level);
            problems.add(new Problem(number, level));
        }

        int recommandCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < recommandCount; i++) {
            st = new StringTokenizer(br.readLine());

            String recommend = st.nextToken();

            if (recommend.equals("add")) {
                int number = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(number, level);

                map.put(number, level);
                problems.add(problem);

            } else if (recommend.equals("recommend")) {
                int re = Integer.parseInt(st.nextToken());

                if (re == 1) {
                    sb.append(problems.last().number).append("\n");
                } else {
                    sb.append(problems.first().number).append("\n");
                }


            } else if (recommend.equals("solved")) {
                int number = Integer.parseInt(st.nextToken());
                problems.remove(new Problem(number, map.get(number)));
            }

        }

        System.out.println(sb);
    }

    public static Comparator<Problem> getComparator() {
        return ((o1, o2) -> {
            if (o1.level == o2.level) {
                return o1.number - o2.number;
            }
            return o1.level - o2.level;
        });
    }


}

class Problem {
    int number;
    int level;

    Problem(int number, int level) {
        this.number = number;
        this.level = level;
    }


}