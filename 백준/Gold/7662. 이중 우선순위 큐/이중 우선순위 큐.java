import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < testCount; i++) {
            TreeMap<Long, Integer> map = new TreeMap<>();
            int commandCount = Integer.parseInt(br.readLine());

            for (int j = 0; j < commandCount; j++) {
                st = new StringTokenizer(br.readLine());


                String command = st.nextToken();
                long target = Integer.parseInt(st.nextToken());

                switch (command) {
                    case "I":
                        map.put(target, map.getOrDefault(target, 0) + 1);
                        break;
                    case "D":
                        if (!map.isEmpty()) {
                            long key;
                            if (target == 1) {
                                key = map.lastKey();
                            } else {
                                key = map.firstKey();
                            }

                            int count = map.get(key);

                            if (count == 1) {
                                map.remove(key);
                            } else {
                                map.put(key, count - 1);
                            }

                        }
                        break;
                }

            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }


        }

        System.out.println(sb.toString());

    }


}

