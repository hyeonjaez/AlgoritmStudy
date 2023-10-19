class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] chars = number.toCharArray();

        int len = chars.length - k;
        int start = 0;
        for (int i = 0; i < len; i++) {
            char max = '0';
            for (int j = start; j <= i + k; j++) {
                if (max < chars[j]) {
                    max = chars[j];
                    start = j + 1;
                }
            }
            sb.append(max - '0');


        }
        return sb.toString();
    }
}