import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> totalTimeMap = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            int number = Integer.parseInt(split[1]);
            String z = split[2];

            if (z.equals("IN")) {
                map.put(number, getCal(time));
            } else {
                if (map.containsKey(number)) {
                    int inTime = map.remove(number);
                    int total = getCal(time) - inTime;
                    totalTimeMap.put(number, totalTimeMap.getOrDefault(number, 0) + total);
                }
            }
        }
        String defaultTime = "23:59";
        int endOfDay = getCal(defaultTime);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int carNumber = entry.getKey();
            int inTime = entry.getValue();
            int total = endOfDay - inTime;

            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + total);
        }

        return totalTimeMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).mapToInt(entry -> money(fees, entry.getValue())).toArray();

    }

    public int money(int[] fees, int time) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int minute = fees[2];
        int fee = fees[3];

        if (time <= defaultTime) {
            return fees[1];
        }


        return defaultFee + (int) Math.ceil((double) (time - defaultTime) / minute) * fee;
    }

    public int getCal(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}