import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);

        HashMap<String, Integer> map = new HashMap<>();

        for (String str : terms) {
            String[] s = str.split(" ");

            map.put(s[0], Integer.parseInt(s[1]));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] splitStr = privacies[i].split(" ");
            LocalDate target = LocalDate.parse(splitStr[0], formatter);

            String str = splitStr[1];

            if (isBefore(map.get(str), todayDate, target)) {
                result.add(i + 1);
            }
        }


        return result.stream().mapToInt(i -> i).toArray();
    }

    public static boolean isBefore(int gigan, LocalDate today, LocalDate target) {
        LocalDate expired = target.plusMonths(gigan);

        return expired.isBefore(today) || expired.equals(today);
    }
}

