import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");

            if (split[2].equals("IN")) {
                map.put(split[1], getTime(split[0]));
            } else {
                int inTime = map.get(split[1]);
                int outTime = getTime(split[0]);

                totalMap.put(split[1], totalMap.getOrDefault(split[1], 0) + outTime - inTime);

                map.remove(split[1]);
            }
        }

        int end = totalMinute(23, 59);
        for (String car : map.keySet()) {
            int in = map.get(car);
            totalMap.put(car, totalMap.getOrDefault(car, 0) + end - in);
        }

        List<String> cars = new ArrayList<>(totalMap.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = calFee(fees, totalMap.get(cars.get(i)));
        }

        return answer;
    }

    public int getTime(String target) {
        String[] split = target.trim().split(":");
        return totalMinute(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }


    public int calFee(int[] fees, int minute) {
        if (minute <= fees[0]) {
            return fees[1];
        }

        int extra = minute - fees[0];
        return fees[1] + (int) Math.ceil((double) extra / fees[2]) * fees[3];
    }

    public int totalMinute(int hour, int minute) {
        return hour * 60 + minute;
    }
}