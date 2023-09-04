package org.example.StringConverter;

public class StringConverter {

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] tokens = str.toCharArray();
        for (char token : tokens) {
            if (65 <= token && token <= 90) {
                sb.append((char) (token + 32));
            } else if (97 <= token && token <= 122) {
                sb.append((char) (token - 32));
            } else {
                sb.append(token);
            }

        }
        return sb.toString();
    }

}
