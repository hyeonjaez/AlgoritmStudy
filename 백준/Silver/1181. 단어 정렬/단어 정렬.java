import java.io.*;
import java.util.*;

public class Main {


//    public static void main(String[] args) {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            int count = Integer.parseInt(br.readLine());
//            Map<Integer, List<String>> map = new HashMap<>();
//
//            for (int i = 0; i < count; i++) {
//                String target = br.readLine();
//
//                int length = target.length();
//                map.computeIfAbsent(length, k -> new ArrayList<>());
//                List<String> list = map.get(length);
//                if (!list.contains(target)) {
//                    list.add(target);
//                }
//            }
//
//            for (List<String> list : map.values()) {
//                list.sort(Comparator.naturalOrder());
//                for (String result : list) {
//                    System.out.println(result);
//                }
//            }
//
//
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            String[] str = new String[count];
            for (int i = 0; i < count; i++) {
                String target = br.readLine();

                str[i] = target;
            }

            Arrays.sort(str, new Comparator<String>() {
                        public int compare(String o1, String o2) {
                            if (o1.length() == o2.length()) {
                                return o1.compareTo(o2);
                            } else {
                                return o1.length() - o2.length();
                            }
                        }
                    }
            );

            System.out.println(str[0]);
            for (int i = 1; i < count; i++) {
                if (!str[i].equals(str[i - 1])) {
                    System.out.println(str[i]);
                }
            }


        } catch (
                IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
